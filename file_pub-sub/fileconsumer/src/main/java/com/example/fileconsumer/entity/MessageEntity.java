package com.example.fileconsumer.entity;

import lombok.Data;

@Data
public class MessageEntity {
    private String topic;
    private byte[] fileBytes;
}
