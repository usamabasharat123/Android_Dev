package com.example.asphalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.loginButton);
        TextView signup = (TextView) findViewById(R.id.signupText);

        //received bundle from the signup page
        String name="";
        String pass="";
        Bundle receivedBundle = getIntent().getExtras();
        if (receivedBundle != null) {
             name = receivedBundle.getString("username");
             pass = receivedBundle.getString("password");
        }

        String finalName = name;
        String finalpass = pass;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("usama") || !finalName.equals("")  && password.getText().toString().equals("0990") || !finalpass.equals(""))
                {
                    Toast.makeText(Login.this , "LOGIN Successful" ,Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("username" , username.getText().toString());

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent data = new Intent(Login.this , Welcome.class);
                            data.putExtras(bundle);
                            startActivity(data);
                            finish();
                        }
                    } ,1000);
                }
                else
                {
                    Toast.makeText(Login.this , "LOGIN Failed!!!" ,Toast.LENGTH_SHORT).show();
                }
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent signup = new Intent(Login.this , Signup.class);
                startActivity(signup);
            }
        });

    }
}