package com.zth.chatbot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ChatEntity {
    @JsonProperty("gpt_type")
    private String gptType;
    private String model;
    private String prompt;
    private String ext;
}
