package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class detial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);


        Intent intent = getIntent();
        String task = intent.getExtras().getString("title");
        TextView taskNameView = findViewById(R.id.dd);
        taskNameView.setText(task);



        Intent intentB = getIntent();
        String taskB = intentB.getExtras().getString("body");
        TextView taskNameBody = findViewById(R.id.BODY);
        taskNameBody.setText(taskB);

    }
}
