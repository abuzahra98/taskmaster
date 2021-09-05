package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

     getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Button goToHomeButton = findViewById(R.id.save);
//        goToHomeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent goToHomeIntent = new Intent(InstructorPage.this, MainActivity.class);
//                startActivity(goToHomeIntent);
//            }
//        });

        Button submitInstructorInfo = findViewById(R.id.save);
        // same as above
        submitInstructorInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Settings.this);
                SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();

                EditText instructorNameField = Settings.this.findViewById(R.id.instructorNameInput);
                String instructorName = instructorNameField.getText().toString();

                sharedPreferencesEditor.putString("instructorName", instructorName);
                sharedPreferencesEditor.apply();

                Intent i = new Intent(Settings.this, MainActivity.class);
                startActivity(i);




            }
        });

    }


}
