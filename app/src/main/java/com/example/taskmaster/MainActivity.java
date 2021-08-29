package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

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
    }
}
