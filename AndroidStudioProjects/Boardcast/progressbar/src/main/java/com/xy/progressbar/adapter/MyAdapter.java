package com.xy.progressbar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xy.progressbar.R;
import com.xy.progressbar.bean.Bean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Bean> data;
    private Context mContext;
    public MyAdapter(Context context, List<Bean> list){
        this.mContext = context;
        this.data = list;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView itemId,itemContent;
        public MyViewHolder(View itemView){
            super(itemView);
            itemContent = (TextView) itemView.findViewById(R.id.item_content);
            itemId = (TextView) itemView.findViewById(R.id.item_id);
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.itemId.setText(String.valueOf(data.get(position).getData()));
        holder.itemContent.setText(data.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
