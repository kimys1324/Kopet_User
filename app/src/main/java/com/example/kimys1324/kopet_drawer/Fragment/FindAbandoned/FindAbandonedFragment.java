package com.example.kimys1324.kopet_drawer.Fragment.FindAbandoned;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.kimys1324.kopet_drawer.Common.CrawlerDB;
import com.example.kimys1324.kopet_drawer.Common.WebCrawler;
import com.example.kimys1324.kopet_drawer.Fragment.Mypage.FingerprintFragment;
import com.example.kimys1324.kopet_drawer.R;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by kimys1324 on 6/30/16.
 */
public class FindAbandonedFragment extends Fragment {

    private WebCrawler crawler;
    // count variable for url crawled so far
    int crawledUrlCount;
    // state variable to check crawling status
    boolean crawlingRunning;
    // For sending message to Handler in order to stop crawling after 60000 ms
    private static final int MSG_STOP_CRAWLING = 111;
    private static final int CRAWLING_RUNNING_TIME = 60000;

    private ImageButton adoptBtn1, adoptBtn2, adoptBtn3, adoptBtn4;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_find_abandoned, container, false);

        adoptBtn1 = (ImageButton)rootView.findViewById(R.id.adoptable_btn1);
        adoptBtn2 = (ImageButton)rootView.findViewById(R.id.adoptable_btn2);
        adoptBtn3 = (ImageButton)rootView.findViewById(R.id.adoptable_btn3);
        adoptBtn4 = (ImageButton)rootView.findViewById(R.id.adoptable_btn4);


        
        adoptBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new AdoptionFragment();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_content, fragment)
                        .addToBackStack(null)
                        .commit();


            }
        });



        /*
        try {
            getDataFromWeb();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        return rootView;

    }

    public void getDataFromWeb() throws IOException {
        Document doc = Jsoup.connect("http://www.animal.go.kr/portal_rnl/abandonment/public_list.jsp").get();

        Log.d("crawl result : ",doc.toString());

    }


}
