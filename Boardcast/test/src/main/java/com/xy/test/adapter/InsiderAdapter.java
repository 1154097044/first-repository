package com.xy.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xy.test.R;
import com.xy.test.beans.OutBean;

import java.util.List;

public class InsiderAdapter extends RecyclerView.Adapter<InsiderAdapter.ViewHolder> {

    private List<OutBean.InsideBean> mInsideBeans;
    private Context mContent;

    public InsiderAdapter(Context context,List<OutBean.InsideBean> insideBeans){
        this.mContent = context;
        this.mInsideBeans = insideBeans;
    }

    @NonNull
    @Override
    public InsiderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tray_detail,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InsiderAdapter.ViewHolder holder, int position) {
        holder.trayCodeTv.setText(mInsideBeans.get(position).getTrayCode());
    }

    @Override
    public int getItemCount() {
        return mInsideBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView trayCodeTv;
        public ViewHolder(View itemView){
            super(itemView);
            trayCodeTv = itemView.findViewById(R.id.tray_code_tv);
        }
    }
}
