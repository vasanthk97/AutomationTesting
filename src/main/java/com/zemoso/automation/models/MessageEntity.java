package com.zemoso.automation.models;

public class MessageEntity {
    private String message;

    public MessageEntity(String message){
        this.message=message;
    }

    public MessageEntity() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
