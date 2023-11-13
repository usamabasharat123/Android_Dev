package com.example.asphalt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Bundle receivedBundle = getIntent().getExtras();
        if (receivedBundle != null) {
            String username = receivedBundle.getString("username");

            // Find the TextView in your layout
            TextView welcomeMessageTextView = (TextView) findViewById(R.id.welcometext);

            // Set the text of the TextView
            if (username != null) {
                welcomeMessageTextView.setText("Welcome " + username);
            }

        }

        Button recycler = (Button) findViewById(R.id.recyclerview);

        recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(Welcome.this , MainActivity.class);
                startActivity(data);
            }
        });

        Button calculator = (Button) findViewById(R.id.calculator);

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(Welcome.this , Calculator.class);
                startActivity(data);
            }
        });

    }
}