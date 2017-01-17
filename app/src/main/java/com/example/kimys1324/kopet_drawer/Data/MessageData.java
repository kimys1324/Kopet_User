package com.example.kimys1324.kopet_drawer.Data;

/**
 * Created by kimys1324 on 7/13/16.
 */
public class MessageData {
    boolean isUser;
    String message;
    String time;

    public MessageData(boolean isUser, String message, String time) {
        this.isUser = isUser;
        this.message = message;
        this.time = time;
    }

    public boolean isSender() {
        return isUser;
    }

    public void setSender(boolean user) {
        isUser = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
