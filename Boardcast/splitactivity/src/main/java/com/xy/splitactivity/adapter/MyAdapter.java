package com.xy.splitactivity.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xy.splitactivity.R;
import com.xy.splitactivity.model.FullPalletDTO;
import com.xy.splitactivity.model.PartialPalletWithFclDT;
import com.xy.splitactivity.model.PartialPalletWithLclDTO;

import java.util.List;

public class MyAdapter<T> extends RecyclerView.Adapter {


    private Context mContext;
    private List<T> mList;
    private boolean isFirst = true;
    public MyAdapter(Context context,List<T> list){
        this.mContext = context;
        this.mList = list;
    }

    public static class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView trayType, trayCount;

        public TitleViewHolder(View itemView) {
            super(itemView);
            trayType = itemView.findViewById(R.id.tray_type);
            trayCount = itemView.findViewById(R.id.tray_count);
        }
    }

    public static class DetailViewHolder extends RecyclerView.ViewHolder {
        TextView trayCode;
        Button trayJump;
        public DetailViewHolder(View itemView) {
            super(itemView);
            trayCode = itemView.findViewById(R.id.tray_code);
            trayJump = itemView.findViewById(R.id.tray_jump);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
