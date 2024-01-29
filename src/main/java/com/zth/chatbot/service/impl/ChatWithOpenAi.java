package com.zth.chatbot.service.impl;

import com.microsoft.cognitiveservices.speech.*;
import com.zth.chatbot.factory.SpeechSynthesizerFactory;
import com.zth.chatbot.service.IChat;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatWithOpenAi implements IChat {

    @Resource
    ChatClient chatClient;
    @Resource
    SpeechSynthesizerFactory speechSynthesizerFactory;

    @Override
    public String chat(String prompt) {
        return chatClient.call(prompt);
    }

    @Override
    public byte[] speak(String prompt) {
        try {
            SpeechSynthesizer speechSynthesizer = speechSynthesizerFactory.create();
            SpeechSynthesisResult speechSynthesisResult = speechSynthesizer.SpeakTextAsync(prompt).get();
            if (speechSynthesisResult.getReason() == ResultReason.SynthesizingAudioCompleted) {
                System.out.println("Speech synthesized to speaker for text [" + prompt + "]");
                return speechSynthesisResult.getAudioData();
            } else if (speechSynthesisResult.getReason() == ResultReason.Canceled) {
                SpeechSynthesisCancellationDetails cancellation = SpeechSynthesisCancellationDetails.fromResult(speechSynthesisResult);
                System.out.println("CANCELED: Reason=" + cancellation.getReason());

                if (cancellation.getReason() == CancellationReason.Error) {
                    System.out.println("CANCELED: ErrorCode=" + cancellation.getErrorCode());
                    System.out.println("CANCELED: ErrorDetails=" + cancellation.getErrorDetails());
                    System.out.println("CANCELED: Did you set the speech resource key and region values?");
                }
                return new byte[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
