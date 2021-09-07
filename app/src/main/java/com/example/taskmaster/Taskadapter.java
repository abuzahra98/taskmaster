package com.example.taskmaster;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class Taskadapter  extends  RecyclerView.Adapter<Taskadapter.taskHolder>{

    List<Todo> allTask = new ArrayList<Todo>();


    public Taskadapter (List<Todo>allTask){
        this.allTask = allTask;
    }
    public  static class taskHolder extends RecyclerView.ViewHolder {

        public Todo task;

        View itemView;
        public taskHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), detial.class);
                   i.putExtra("title",task.getTitle());
                    i.putExtra("body",task.getBody());
                    i.putExtra("status",task.getStatus());

                    v.getContext().startActivity(i);
                }
            });
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
        TextView status = holder.itemView.findViewById(R.id.aa);

        titel.setText(holder.task.getTitle());
        body.setText(holder.task.getBody());
        status.setText(holder.task.getStatus());







    }

    @Override
    public int getItemCount() {
        return allTask.size();
    }
}
