package com.example.onlinebanksystem.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MessageResponse {

    private final MessageType messageType;
    private final String message;

    public boolean hasError() {
        return messageType.equals(MessageType.ERROR);
    }
}
