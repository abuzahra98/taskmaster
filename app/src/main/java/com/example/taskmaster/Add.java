package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Todo;

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
//       Task task = new Task(titel.getText().toString(),body.getText().toString(),status.getText().toString());
//                appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"ddd").allowMainThreadQueries().build();

//                TaskDao taskDao = appDatabase.taskDao();
//                appDatabase.taskDao().insertAll(task);


                Todo todo = Todo.builder()
                        .title(titel.getText().toString())
                        .body(body.getText().toString())
                        .status(status.getText().toString())
                        .build();



                Amplify.API.mutate(
                        ModelMutation.create(todo),
                        response -> Log.i("MyAmplifyApp", "Added Todo with id: " + response.getData().getId()),
                        error -> Log.e("MyAmplifyApp", "Create failed", error)
                );

//                try {
//                    Amplify.addPlugin(new AWSApiPlugin()); // UNCOMMENT this line once backend is deployed
//                    Amplify.addPlugin(new AWSDataStorePlugin());
//                    Amplify.configure(getApplicationContext());
//
//                    Log.i("MyAmplifyApp", "Initialized Amplify");
//
//
//                } catch (AmplifyException error) {
//                    Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
//                }



            }
        });
    }
}
