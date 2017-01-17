package com.example.kimys1324.kopet_drawer.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.kimys1324.kopet_drawer.R;

/**
 * Created by kimys1324 on 7/6/16.
 */
public class Login extends Activity {

    private ImageButton loginButton;
    private ImageButton create_account_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.loginButton = (ImageButton)findViewById(R.id.login_button);
        this.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentForDrawer = new Intent(Login.this, Kopet_main.class);
                startActivity(intentForDrawer);

            }
        });

        this.create_account_btn = (ImageButton)findViewById(R.id.create_account_btn);
        this.create_account_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intentForDrawer = new Intent(Login.this, CreateAccount.class);
                startActivity(intentForDrawer);

            }
        });

    }
}
