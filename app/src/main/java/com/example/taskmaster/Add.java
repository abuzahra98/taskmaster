package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        Button first = findViewById(R.id.button3);
        first.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"submitted!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
