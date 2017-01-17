package com.example.kimys1324.kopet_drawer.Fragment.DirectMessage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kimys1324.kopet_drawer.Data.Chatting;
import com.example.kimys1324.kopet_drawer.Data.MessageData;
import com.example.kimys1324.kopet_drawer.R;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by kimys1324 on 7/13/16.
 */
public class ChattingFragment extends Fragment {

    private Chatting chat;
    private ListView messageListView;
    private ArrayList<MessageData> messages;

    private ArrayAdapter<String> listAdapter;
    private View chatView;

    //public ChattingFragment(Chatting chat)
    {
        this.chat = chat;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_chatting, container, false);
        chatView = inflater.inflate(R.layout.direct_msg_chat_item, container, false);
        /*
        listAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.direct_msg_chat_item);

        messageListView = (ListView)rootView.findViewById(R.id.directMessage_listview);
        messageListView.setAdapter(listAdapter);
        messageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do nothing
            }
        });
        */

        return rootView;
    }

    public void addChats()
    {

    }

    public void sendMessage(String text)
    {
        MessageData newmsg = new MessageData(true, text, android.text.format.Time.getCurrentTimezone().toString());

    }

    public void addUsrMsg(String text)
    {
        FrameLayout chatFrame = (FrameLayout)chatView.findViewById(R.id.chat_frame);

        chatFrame.setBackground(getContext().getResources().getDrawable(R.drawable.img_usr_txt_bg));

        TextView usrTxt = (TextView)chatView.findViewById(R.id.chat_txt);

        usrTxt.setGravity(Gravity.LEFT);

        usrTxt.setText(text);

        listAdapter.add(text);


    }
    public void addOthMsg(String text)
    {
        FrameLayout chatFrame = (FrameLayout)chatView.findViewById(R.id.chat_frame);

        chatFrame.setBackground(getContext().getResources().getDrawable(R.drawable.img_oth_txt_bg));

        TextView usrTxt = (TextView)chatView.findViewById(R.id.chat_txt);

        usrTxt.setGravity(Gravity.RIGHT);

        usrTxt.setText(text);

        listAdapter.add(text);
    }




}
