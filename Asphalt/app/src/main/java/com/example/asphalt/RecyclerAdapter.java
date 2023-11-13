package com.example.asphalt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    Context context;
    ArrayList<Model> arrayList;

    RecyclerAdapter(Context context , ArrayList<Model> arrayList)
    {
        this.context=context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(context).inflate(R.layout.entrystyle, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.studentimg.setImageResource(arrayList.get(position).image);
        holder.studentname.setText(arrayList.get(position).name);
        holder.studentemail.setText(arrayList.get(position).email);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView studentname , studentemail;
        ImageView studentimg;
        public ViewHolder(View itemview)
        {
            super(itemview);
            studentname = itemview.findViewById(R.id.studentname);
            studentemail = itemview.findViewById(R.id.studentemail);
            studentimg = itemview.findViewById(R.id.studentimg);
        }
    }
}
