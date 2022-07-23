package com.xy.recycleview.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.xy.recycleview.R;
import com.xy.recycleview.beans.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultiViewTypeAdapter extends RecyclerView.Adapter {

    private ArrayList<Model> dataSet;
    private Context mContext;
    int total_types;
    MediaPlayer mediaPlayer;
    private boolean fabStateVolume = false;

    public MultiViewTypeAdapter(Context context, ArrayList<Model> data) {
        this.dataSet = data;
        this.mContext = context;
        this.total_types = dataSet.size();
    }

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {
        TextView txView;
        CardView cardView;

        public TextTypeViewHolder(View itemView) {
            super(itemView);
            txView = itemView.findViewById(R.id.tx_view);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {
        ImageView ivView;
        TextView ivText;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);
            ivView = itemView.findViewById(R.id.iv_view);
            ivText = itemView.findViewById(R.id.iv_text);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Model.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_text, parent, false);
                return new TextTypeViewHolder(view);
            case Model.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image, parent, false);
                return new ImageTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {
        Model object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case Model.TEXT_TYPE:
                    ((TextTypeViewHolder) holder).txView.setText(object.text);
                    break;
                case Model.IMAGE_TYPE:
                    ((ImageTypeViewHolder)holder).ivText.setText(object.text);
                    ((ImageTypeViewHolder)holder).ivView.setImageResource(object.data);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataSet.get(position).type) {
            case 0:
                return Model.TEXT_TYPE;
            case 1:
                return Model.IMAGE_TYPE;
            default:
                return -1;
        }
    }
}
