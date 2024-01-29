package com.zth.chatbot.service.impl;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.speaker.SpeakerRecognizer;
import com.zth.chatbot.service.ISpeak;
import com.zth.chatbot.util.WavStreamUtils;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class SpeakToOpenAi implements ISpeak {

    @Resource
    SpeechConfig speechConfig;
    @Resource
    ChatClient chatClient;

    @Override
    public byte[] speak(byte[] bytes) {
        return new byte[0];
    }

    @Override
    public String chat(byte[] bytes) {

        WavStreamUtils wavStreamUtils = new WavStreamUtils(new ByteArrayInputStream(bytes));
        AudioConfig audioConfig = AudioConfig.fromStreamInput(wavStreamUtils);
        SpeakerRecognizer speakerRecognizer = new SpeakerRecognizer(speechConfig, audioConfig);
        //
        return null;
    }
}
