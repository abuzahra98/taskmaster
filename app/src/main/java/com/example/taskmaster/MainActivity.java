package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    List<Todo> taskList =new ArrayList<>();

    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);




        try {

            Amplify.addPlugin(new AWSApiPlugin()); // UNCOMMENT this line once backend is deployed
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());

            Amplify.configure(getApplicationContext());


            Amplify.Auth.signInWithWebUI(
                    this,
                    result -> Log.i("AuthQuickStart", result.toString()),
                    error -> Log.e("AuthQuickStart", error.toString())
            );
            Log.i("MyAmplifyApp", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
        }

//          appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"ddd").allowMainThreadQueries().build();
//        List<Todo> taskList = appDatabase.taskDao().getAll();
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


        Button signOut=findViewById(R.id.signout);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Amplify.Auth.signOut(
                        () -> {

                            Log.i("AuthQuickstart", "Signed out successfully");
                        },
                        error -> Log.e("AuthQuickstart", error.toString())
                );
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String welcomeMessage = "Welcome ";
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String instructorName = sharedPreferences.getString("instructorName", "Instructor");
        TextView instructorNameView = findViewById(R.id.output);
        instructorNameView.setText( instructorName + "s tasks");
        Toast.makeText(getApplicationContext(), "onResume callback!", Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onStart() {
        super.onStart();
        RecyclerView allTasks = findViewById(R.id.ss);
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                allTasks.getAdapter().notifyDataSetChanged();
                return false;
            }
        });
        Amplify.API.query(
                ModelQuery.list(com.amplifyframework.datastore.generated.model.Todo.class),
//                ModelQuery.list(Todo.class),
                response -> {
                    for (Todo todo : response.getData()) {

                        taskList.add(todo);
                    }
                    handler.sendEmptyMessage(1);
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
        allTasks.setLayoutManager(new LinearLayoutManager(this));
        allTasks.setAdapter(new Taskadapter(taskList));


    }




    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause callback!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop callback!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart callback!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy callback!", Toast.LENGTH_SHORT).show();

    }
}


