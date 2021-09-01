package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Add extends AppCompatActivity {
AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText titel = findViewById(R.id.newTaskBody);
        final EditText body = findViewById(R.id.newTaskName);
        final EditText status = findViewById(R.id.status);

        Button first = findViewById(R.id.button3);
        first.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v) {
       Task task = new Task(titel.getText().toString(),body.getText().toString(),status.getText().toString());
                appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"ddd").allowMainThreadQueries().build();

                TaskDao taskDao = appDatabase.taskDao();
                appDatabase.taskDao().insertAll(task);


                Toast.makeText(getApplicationContext(),"submitted!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
