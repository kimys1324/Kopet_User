package com.example.kimys1324.kopet_drawer.Fragment.CreateAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;

import com.example.kimys1324.kopet_drawer.R;

/**
 * Created by kimys1324 on 7/13/16.
 */
public class AgreementFragment extends Fragment {

    ImageButton nextBtn;
    CheckBox chkb1, chkb2;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_agreement, container, false);


        nextBtn = (ImageButton)rootView.findViewById(R.id.agr_next_btn);
        chkb1 = (CheckBox)rootView.findViewById(R.id.agr_ckb1);
        chkb2 = (CheckBox)rootView.findViewById(R.id.agr_ckb2);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkb1.isChecked() && chkb2.isChecked())
                {
                    Fragment fragment = new InputInformFragment();

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.create_account_main_content, fragment)
                            .addToBackStack(null)
                            .commit();
                }
                else
                {
                    //약관 동의 Toast
                }
            }
        });

        return rootView;
    }

}
