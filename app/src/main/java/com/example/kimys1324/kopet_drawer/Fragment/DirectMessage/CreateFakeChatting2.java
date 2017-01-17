package com.example.kimys1324.kopet_drawer.Fragment.DirectMessage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kimys1324.kopet_drawer.Data.Chatting;
import com.example.kimys1324.kopet_drawer.Data.MessageData;
import com.example.kimys1324.kopet_drawer.R;

/**
 * Created by kimys1324 on 7/14/16.
 */
public class CreateFakeChatting2 extends Fragment {

    private Chatting chat;



    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_chatting, container, false);

        return rootView;
    }

    public void addChats()
    {

    }

    public void sendMessage(String text)
    {
        MessageData newmsg = new MessageData(true, text, android.text.format.Time.getCurrentTimezone().toString());



    }
}
