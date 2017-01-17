package com.example.kimys1324.kopet_drawer.Fragment.Mypage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.kimys1324.kopet_drawer.Data.PetData;
import com.example.kimys1324.kopet_drawer.R;


/**
 * Created by kimys1324 on 6/30/16.
 */
public class ReportFragment extends Fragment {

    private Bundle activityBundle;

    private CheckBox cb;

    private PetData missingpet;

    private ImageButton reportBtn1, reportBtn2;

    public ReportFragment(){}

    private TextView t[];


/*
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

    }
    */
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_report_missing_pet1, container, false);

        reportBtn1 = (ImageButton)rootView.findViewById(R.id.report_missing_finish);
        reportBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportMissing();
            }
        });

        cb = (CheckBox)rootView.findViewById(R.id.cb);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    t[0].setText("달리");

                    t[1].setText("포메라니안");
                    t[2].setText("화이트");
                    t[3].setText("남아");
                    t[4].setText("4개월");
                    t[5].setText("왼쪽다리에 상처가 있음");
                    t[6].setText("홍태지");
                    t[7].setText("taeji@naver.com");
                    t[8].setText("01088013092");
                    t[12].setText("41018009362");
                    t[13].setText("41018009362");
                }
                else
                {

                    for(int i=0 ; i<9 ; i++)
                    {
                        t[i].setText("");
                    }

                }
            }
        });

        t = new TextView[14];

        t[0] = (TextView)rootView.findViewById(R.id.t1);
        t[1] = (TextView)rootView.findViewById(R.id.t2);
        t[2] = (TextView)rootView.findViewById(R.id.t3);
        t[3] = (TextView)rootView.findViewById(R.id.t4);
        t[4] = (TextView)rootView.findViewById(R.id.t5);
        t[5] = (TextView)rootView.findViewById(R.id.t6);
        t[6] = (TextView)rootView.findViewById(R.id.t7);
        t[7] = (TextView)rootView.findViewById(R.id.t8);
        t[8] = (TextView)rootView.findViewById(R.id.t9);
        t[12] = (TextView)rootView.findViewById(R.id.t13);
        t[13] = (TextView)rootView.findViewById(R.id.t14);


        for(int i=0 ; i<9 ; i++)
        {
            t[i].setText("");
        }
        /*
        reportBtn = (ImageButton)rootView.findViewById(R.id.report_missing_sure);

        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //report action
            }
        });
        */
        return rootView;
    }

    private void reportMissing()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());

        builder.setMessage("접수완료되었습니다")
                .setPositiveButton("마이페이지로 이동", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Fragment fragment = new MypageFragment();

                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_content, fragment)
                                .addToBackStack(null)
                                .commit();

                        //확인 눌렀을 때 Action
                    }
                } );
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
