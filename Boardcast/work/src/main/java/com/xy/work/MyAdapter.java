package com.xy.work;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    private List<Model> dataSet;
    private Context mContext;
    private Activity mActivity;

    public MyAdapter(Context context, List<Model> list,Activity activity) {
        this.dataSet = list;
        this.mContext = context;
        this.mActivity = activity;
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

    @Override
    public int getItemViewType(int position) {
        switch (dataSet.get(position).getType()) {
            case 0:
                return Model.TITLE;
            case 1:
                return Model.DETAIL;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Model.TITLE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tray_titile, parent, false);
                return new TitleViewHolder(view);
            case Model.DETAIL:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tray_detail, parent, false);
                return new DetailViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {
        Model object = dataSet.get(listPosition);
        if(object != null) {
            switch (object.getType()) {
                case Model.TITLE:
                    ((TitleViewHolder) holder).trayType.setText(object.getText());
                    ((TitleViewHolder) holder).trayCount.setText(String.valueOf(object.getData()));
                    break;
                case Model.DETAIL:
                    ((DetailViewHolder) holder).trayCode.setText(object.getText());
                    ((DetailViewHolder) holder).trayJump.setOnClickListener(v -> {
                        Intent intent = ScanJump.getIntent(mContext,object.getText());
                        mActivity.startActivity(intent);
                    });
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
