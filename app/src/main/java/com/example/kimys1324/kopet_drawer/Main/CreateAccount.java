package com.example.kimys1324.kopet_drawer.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.kimys1324.kopet_drawer.Fragment.CreateAccount.AgreementFragment;
import com.example.kimys1324.kopet_drawer.Fragment.Mypage.MypageFragment;
import com.example.kimys1324.kopet_drawer.R;

import java.lang.reflect.AccessibleObject;

/**
 * Created by kimys1324 on 7/13/16.
 */
public class CreateAccount extends AppCompatActivity {


    public void onBackPressed()
    {
        Intent intentForDrawer = new Intent(CreateAccount.this, Login.class);
        startActivity(intentForDrawer);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        Fragment fragment = new AgreementFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.create_account_main_content, fragment)
                .addToBackStack(null)
                .commit();

    }

}
