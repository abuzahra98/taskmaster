package com.example.taskmaster;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)
    public int idTask;

    @ColumnInfo  (name= "Task_title")
    public  String title;

    @ColumnInfo  (name= "Task_body")
    public  String body;

    @ColumnInfo  (name= "Task_status")
    public String status;

    public Task(String title, String body , String status) {
        this.title = title;
        this.body = body;
        this.status = status;
    }


}
