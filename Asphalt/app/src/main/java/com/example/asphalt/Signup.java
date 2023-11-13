package com.example.asphalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView username = (TextView) findViewById(R.id.newusername);
        TextView password = (TextView) findViewById(R.id.newpassword);

        Button signupnow = (Button) findViewById(R.id.signupnow);


        signupnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!username.getText().toString().equals("") && !password.getText().toString().equals(""))
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("username" , username.getText().toString());
                    bundle.putString("password" , password.getText().toString());

                    Intent data = new Intent(Signup.this , Login.class);
                    data.putExtras(bundle);
                    startActivity(data);
                    finish();
                }
                else
                {
                    Toast.makeText(Signup.this , "Please Fill the required Fields" ,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}