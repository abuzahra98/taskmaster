package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PathDashPathEffect;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

          appDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"ddd").allowMainThreadQueries().build();
        List<Task> taskList = appDatabase.taskDao().getAll();
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

        ArrayList<Task> allTask = new ArrayList<Task>();
        allTask.add(new Task("Football","      Several codes of football. Left to right, top to bottom: association, gridiron, Australian rules, rugby union, rugby league and Gaelic Football is a family of team sports that involve, to varying degrees, kicking a ball to score a goal. Unqualified, the word football normally means the form of football that is the most popular where the word is used. Sports commonly called football include association football (known as soccer in North America and Oceania); gridiron football (specifically American football or Canadian football); Australian rules football; rugby union and rugby league; and Gaelic football.[1] These various forms of football share to varying extent common origins and are known as football codes.","in progress"));
        allTask.add(new Task("Basketball","Basketball is a team sport in which two teams, most commonly of five players each, opposing one another on a rectangular court, compete with the primary objective of shooting a basketball (approximately 9.4 inches (24 cm) in diameter) through the defender's hoop (a basket 18 inches (46 cm) in diameter mounted 10 feet (3.048 m) high to a backboard at each end of the court) while preventing the opposing team from shooting through their own hoop. A field goal is worth two points, unless made from behind the three-point line, when it is worth three. After a foul, timed play stops and the player fouled or designated to shoot a technical foul is given one, two or three one-point free throws.","assign"));
        allTask.add(new Task("Bowling","Bowling is a target sport and recreational activity in which a player rolls a ball toward pins (in pin bowling) or another target (in target bowling). The term bowling usually refers to pin bowling (most commonly ten-pin bowling), though in the United Kingdom and Commonwealth countries, bowling could also refer to target bowling, such as lawn bowls.","completed"));
        RecyclerView allTasks = findViewById(R.id.ss);
        allTasks.setLayoutManager(new LinearLayoutManager(this));
        allTasks.setAdapter(new Taskadapter(taskList));
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
