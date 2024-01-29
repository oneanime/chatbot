package com.zth.chatbot.service;

public interface IChat {
    String chat(String prompt);
    byte[] speak(String prompt);
}
