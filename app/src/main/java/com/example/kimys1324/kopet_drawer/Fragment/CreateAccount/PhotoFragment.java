package com.example.kimys1324.kopet_drawer.Fragment.CreateAccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.kimys1324.kopet_drawer.Main.Kopet_main;
import com.example.kimys1324.kopet_drawer.R;

/**
 * Created by kimys1324 on 7/13/16.
 */
public class PhotoFragment extends Fragment {


    ImageButton prof_upbtn, prof_finbtn;
    Button ant_photo_btn;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_profile_photo_reg, container, false);

        prof_upbtn = (ImageButton)rootView.findViewById(R.id.fin_photo_upload_btn);
        ant_photo_btn = (Button)rootView.findViewById(R.id.fin_ant_photo_upload_btn);
        prof_finbtn = (ImageButton)rootView.findViewById(R.id.fin_crt_finish_btn);

        prof_upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //upload Photo
            }
        });

        ant_photo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //upload Photo (Same function)
            }
        });

        prof_finbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentForDrawer = new Intent(getActivity() , Kopet_main.class);
                startActivity(intentForDrawer);

            }
        });


        return rootView;
    }


}
