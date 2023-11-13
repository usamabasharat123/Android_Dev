package com.example.asphalt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> students  = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;
    FloatingActionButton OpenDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        OpenDialog = findViewById(R.id.OpenDialog);

        OpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_box);

                EditText name = dialog.findViewById(R.id.name);
                EditText email= dialog.findViewById(R.id.email);
                Button button = dialog.findViewById(R.id.addinfo);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Name = "", Email = "";

                        if (!name.getText().toString().equals("")) {
                            Name = name.getText().toString();
                        }
                        if (!email.getText().toString().equals("")) {
                            Email = email.getText().toString();
                        }
                        if(!Name.equals("") && !Email.equals("")) {
                            students.add(new Model(R.drawable.male, Name, Email));
                            recyclerAdapter.notifyItemInserted(students.size() - 1);
                            recyclerView.scrollToPosition(students.size() - 1);
                            dialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Invalid Action!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                dialog.show();

            }
        });

        students.add(new Model(R.drawable.male, "Usama Basharat"  ,"Bitf20m528"));
        students.add(new Model(R.drawable.male , "abdul qadir"  ,"Bitf20m510"));
        students.add(new Model(R.drawable.male , "Subktgeen Babar"  ,"Bitf20m541"));
        students.add(new Model(R.drawable.male , "Muhammad Asad"  ,"Bitf20m533"));
        students.add(new Model(R.drawable.female , "Ramisha Rauf"  ,"Bitf20m517"));
        students.add(new Model(R.drawable.female , "Noor Ul Ain"  ,"Bitf20m508"));
        students.add(new Model(R.drawable.male , "Ahmed"  ,"Bitf20m534"));
        students.add(new Model(R.drawable.female , "zainab zulfqar"  ,"Bitf20m511"));
        students.add(new Model(R.drawable.male , "Babar"  ,"Bitf20m541"));
        students.add(new Model(R.drawable.male , "Muhammad Amar"  ,"Bitf20m530"));
        students.add(new Model(R.drawable.female , "Ramisha"  ,"Bitf20m517"));
        students.add(new Model(R.drawable.male , "Asim"  ,"Bitf20m590"));


        recyclerAdapter = new RecyclerAdapter(this,students);
        recyclerView.setAdapter(recyclerAdapter);
    }
}