package com.zth.chatbot.service;

public interface ISpeak {
    byte[] speak(byte[] bytes);
    String chat(byte[] bytes);
}
