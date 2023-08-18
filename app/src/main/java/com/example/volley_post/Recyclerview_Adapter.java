package com.example.volley_post;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.Holder> {
    MainActivity mainActivity;
    ArrayList<Model> list;
    public Recyclerview_Adapter(MainActivity mainActivity, ArrayList<Model> list) {
        this.mainActivity=mainActivity;
        this.list=list;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.recyclerview_item_layuot,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.Holder holder, int position) {
        holder.t1.setText(""+list.get(position).getId());
        holder.t2.setText(""+list.get(position).getTitle());
        holder.t3.setText(""+list.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        public Holder(@NonNull View itemView) {
            super(itemView);
             t1=itemView.findViewById(R.id.textid);
            t2=itemView.findViewById(R.id.title);
            t3=itemView.findViewById(R.id.body);
        }
    }
}
