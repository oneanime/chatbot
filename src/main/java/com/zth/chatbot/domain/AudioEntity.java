package com.zth.chatbot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AudioEntity {
    @JsonProperty("gpt_type")
    private String gptType;
    private String model;
    @JsonProperty("audio_base64")
    private String audioBase64;
    private String ext;
}
