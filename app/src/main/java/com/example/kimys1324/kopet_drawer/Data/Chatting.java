package com.example.kimys1324.kopet_drawer.Data;

import java.util.ArrayList;

/**
 * Created by kimys1324 on 7/13/16.
 */
public class Chatting {
    private String name;
    private ArrayList<MessageData> messager;

    public Chatting(String name, ArrayList<MessageData> messager) {
        this.name = name;
        this.messager = messager;
    }

    public ArrayList<MessageData> getMessager() {
        return messager;
    }

    public void setMessager(ArrayList<MessageData> messager) {
        this.messager = messager;
    }

    public void addMessage(MessageData mes)
    {
        messager.add(mes);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
