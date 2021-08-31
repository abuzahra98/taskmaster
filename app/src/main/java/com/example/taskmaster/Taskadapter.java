package com.example.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Taskadapter  extends  RecyclerView.Adapter<Taskadapter.taskHolder>{

    List<Task> allTask = new ArrayList<>();


    public Taskadapter (List<Task>allTask){
        this.allTask = allTask;
    }
    public  static class taskHolder extends RecyclerView.ViewHolder {

        public Task task;

        View itemView;
        public taskHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }







    @NonNull
    @Override
    public taskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_tasksfragment,parent,false);
 taskHolder taskhold = new taskHolder(view);
        return taskhold;
    }

    @Override
    public void onBindViewHolder(@NonNull taskHolder holder, int position) {
holder.task = allTask.get(position);
        TextView titel = holder.itemView.findViewById(R.id.textView12);
        TextView body = holder.itemView.findViewById(R.id.body);
//        titel.sett

        titel.setText(holder.task.title);
        body.setText(holder.task.body);






    }

    @Override
    public int getItemCount() {
        return allTask.size();
    }
}
