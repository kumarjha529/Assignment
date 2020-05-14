package com.assignment.own;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.DataHolder> {
    private List<storedata> storedatas;
    Context context;

    public DataAdapter(List<storedata> storedatas, Context context) {
        this.storedatas = storedatas;
        this.context = context;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.show_model,parent,false);

        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {

        holder.abc.setText(storedatas.get(position).getId());
        holder.url.setText(storedatas.get(position).getRepository_url());
        holder.statr.setText(storedatas.get(position).getState());

        String v = (String) holder.statr.getText();

        if(v.equals("open"))
        {
            holder.box.setChecked(true);
        }else {
            holder.box.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return storedatas.size();
    }


    public class DataHolder extends RecyclerView.ViewHolder {
        TextView abc,url,statr;
        CheckBox box;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            abc = itemView.findViewById(R.id.id1);
            url = itemView.findViewById(R.id.url1);
            statr = itemView.findViewById(R.id.state);
            box = itemView.findViewById(R.id.state1);


        }
    }
}
