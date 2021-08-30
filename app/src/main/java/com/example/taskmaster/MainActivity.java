package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

         Button first = findViewById(R.id.button1);
       first.setOnClickListener(new  OnClickListener(){

           @Override
           public void onClick(View v) {
               Intent i = new Intent(MainActivity.this, Add.class);
               startActivity(i);
//               Toast.makeText(getApplicationContext(),"submit done",Toast.LENGTH_LONG).show();
           }
       });

        Button sec = findViewById(R.id.button2);
        sec.setOnClickListener(new  OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, All.class);
                startActivity(i);
            }
        });

        Button settings = findViewById(R.id.settings);
        settings.setOnClickListener(new  OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Settings.class);
                startActivity(i);
            }
        });

        Button Football = findViewById(R.id.Football);
        Football.setOnClickListener(new  OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Football.class);
                startActivity(i);
            }
        });

        Button Basketball = findViewById(R.id.Basketball);
        Basketball.setOnClickListener(new  OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Basketball.class);
                startActivity(i);
            }
        });

        Button Bowling = findViewById(R.id.Bowling);
        Bowling.setOnClickListener(new  OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Bowling.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String welcomeMessage = "Welcome ";
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String instructorName = sharedPreferences.getString("instructorName", "Instructor");
        TextView instructorNameView = findViewById(R.id.welcome);
        instructorNameView.setText( instructorName + "s tasks");
    }
}
