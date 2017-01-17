package com.example.kimys1324.kopet_drawer.Fragment.FindAbandoned;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kimys1324.kopet_drawer.Common.AdapterForChatting;
import com.example.kimys1324.kopet_drawer.R;

/**
 * Created by kimys1324 on 7/16/16.
 */
public class RequestAdoptionFragment extends Fragment {


    ListView m_ListView;
    AdapterForChatting m_Adapter;
    TextView title;

    EditText requestText;
    ImageButton sendBtn;


    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_request_chat, container, false);

        requestText = (EditText)rootView.findViewById(R.id.request_chat);
        sendBtn = (ImageButton)rootView.findViewById(R.id.request_chat_send_button);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendMsg = requestText.getText().toString();

                if(sendMsg==null){}
                else
                {
                    m_Adapter.add(sendMsg,0);
                    requestText.setText("");
                    scrollMyListViewToBottom();

                }
            }
        });

        m_Adapter = new AdapterForChatting();

        // Xml에서 추가한 ListView 연결
        m_ListView = (ListView) rootView.findViewById(R.id.request_chatting_list);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        m_Adapter.add("공고에 나와있는 강아지를 입양하고 싶은데 어떻게 하면 되나요?",0);
        m_Adapter.add("필요한 서류들을 준비하셔서 편하신날 오전 9시부터 오후 5시 사이에 저희 센터로 방문해주시면 됩니다.",1);
        m_Adapter.add("네, 그러면 내일 10시에 찾아뵙겠습니다.",0);
        m_Adapter.add("네 알겠습니다.",1);
        scrollMyListViewToBottom();
        return rootView;

    }

    private void scrollMyListViewToBottom() {
        m_ListView.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                m_ListView.setSelection(m_Adapter.getCount() - 1);
            }
        });
    }
}
