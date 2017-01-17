package com.example.kimys1324.kopet_drawer.Fragment.CreateAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.kimys1324.kopet_drawer.R;

/**
 * Created by kimys1324 on 7/13/16.
 */
public class InputInformFragment extends Fragment {


    ImageButton nxtBtn;
    EditText edt_usr_id, edt_usr_pw, edt_usr_pw_chk, edt_usr_name, edt_usr_adr, edt_usr_gend, edt_usr_birth, edt_usr_numb;



    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_chatting, container, false);

        nxtBtn = (ImageButton)rootView.findViewById(R.id.inform_nxt_btn);
        edt_usr_id = (EditText)rootView.findViewById(R.id.inform_usr_id);

        edt_usr_pw = (EditText)rootView.findViewById(R.id.inform_usr_pwd);
        edt_usr_pw_chk = (EditText)rootView.findViewById(R.id.inform_usr_pwd_chk);

        edt_usr_name = (EditText)rootView.findViewById(R.id.inform_usr_name);
        edt_usr_adr = (EditText)rootView.findViewById(R.id.inform_usr_adr);

        edt_usr_gend = (EditText)rootView.findViewById(R.id.inform_usr_gender);

        edt_usr_birth = (EditText)rootView.findViewById(R.id.inform_usr_birth);

        edt_usr_numb = (EditText)rootView.findViewById(R.id.inform_usr_number);

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_usr_id.getText()==null)
                {
                    Toast.makeText(getActivity().getApplicationContext(), "ID를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(edt_usr_pw.getText()==null){
                    Toast.makeText(getActivity().getApplicationContext(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();}
                else if(edt_usr_pw_chk.getText()==null){
                    Toast.makeText(getActivity().getApplicationContext(), "비밀번호 확인을 입력해주세요.", Toast.LENGTH_SHORT).show();}
                else if(edt_usr_name.getText()==null){
                    Toast.makeText(getActivity().getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();}
                else if(edt_usr_adr.getText()==null){
                    Toast.makeText(getActivity().getApplicationContext(), "주소를 입력해주세요.", Toast.LENGTH_SHORT).show();}
                else if(edt_usr_gend.getText()==null){
                    Toast.makeText(getActivity().getApplicationContext(), "성별을 입력해주세요.", Toast.LENGTH_SHORT).show();}
                else if(edt_usr_birth.getText()==null){
                    Toast.makeText(getActivity().getApplicationContext(), "생년월일을 입력해주세요.", Toast.LENGTH_SHORT).show();}
                else if(edt_usr_numb.getText()==null){
                    Toast.makeText(getActivity().getApplicationContext(), "번호를 입력해주세요.", Toast.LENGTH_SHORT).show();}
                else if(!edt_usr_pw.getText().equals(edt_usr_pw_chk))
                {
                    //비밀번호 recheck
                }
                else
                {
                    Fragment fragment = new PhotoFragment();

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.create_account_main_content, fragment)
                            .addToBackStack(null)
                            .commit();
                }


            }
        });

        return rootView;
    }

}
