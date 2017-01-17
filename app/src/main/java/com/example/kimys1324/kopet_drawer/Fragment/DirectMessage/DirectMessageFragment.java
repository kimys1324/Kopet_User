package com.example.kimys1324.kopet_drawer.Fragment.DirectMessage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kimys1324.kopet_drawer.Data.Chatting;
import com.example.kimys1324.kopet_drawer.Data.MessageData;
import com.example.kimys1324.kopet_drawer.R;

import java.util.ArrayList;

/**
 * Created by kimys1324 on 7/1/16.
 */
public class DirectMessageFragment extends Fragment {

    private ListView messageListView;
    private ArrayAdapter<String> listAdapter;
    private ArrayList<Chatting> chats;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

       View rootView = inflater.inflate(R.layout.fragment_direct_message, container, false);
        //View rootView = inflater.inflate(R.layout.fragment_report_missing_pet1, container, false);

        /*
        listAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.direct_msg_listitem);
        messageListView = (ListView)rootView.findViewById(R.id.directMessage_listview);
        messageListView.setAdapter(listAdapter);
        messageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String anotherName = listAdapter.getItem(position);

                Fragment fragment = new ChattingFragment(chats.get(position));

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_content, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        */

        return rootView;
    }



    public void addNewChat(String name)
    {
        listAdapter.add(name);
        Chatting chat = new Chatting(name, new ArrayList<MessageData>());
        chats.add(chat);
    }

}
