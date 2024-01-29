package com.zth.chatbot.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.StreamingChatClient;
import org.springframework.ai.chat.messages.ChatMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController("/chat")
public class ChatController {

    @Resource
    ChatClient chatClient;

    @Resource
    StreamingChatClient streamingChatClient;


    @PostMapping
    public String chat(String prompt) {
        return chatClient.call(prompt);
    }

    @PostMapping("/stream")
    public Flux<String> chatStream(String prompt) {
        return streamingChatClient.
                stream(new Prompt(prompt))
                .map(Object::toString);
    }


}
