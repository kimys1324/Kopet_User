package com.example.kimys1324.kopet_drawer.Fragment.Mypage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.kimys1324.kopet_drawer.R;

/**
 * Created by kimys1324 on 7/16/16.
 */
public class Pet1EditFragment extends Fragment {

    ImageButton editFinishBtn;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.card_pet1_edit, container, false);

        editFinishBtn = (ImageButton)rootView.findViewById(R.id.pet1_card_finish_edit_btn);

        return rootView;
    }

}
