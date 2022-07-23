package com.xy.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xy.test.R;
import com.xy.test.beans.OutBean;

import java.util.List;

public class OutAdapter extends RecyclerView.Adapter<OutAdapter.ViewHolder> {

    private List<OutBean> mOutBeans;
    private Context mContext;

    public OutAdapter(Context context,List<OutBean> outBeans){
        this.mContext =context;
        this.mOutBeans = outBeans;
    }

    @NonNull
    @Override
    public OutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tray_type,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OutAdapter.ViewHolder holder, int position) {
        if (holder.traySplitRv.getAdapter() == null) {
            holder.trayType.setText(mOutBeans.get(position).getName());
            holder.trayNum.setText(String.valueOf(mOutBeans.get(position).getCount()));
            holder.traySplitRv.setAdapter(new InsiderAdapter(mContext,mOutBeans.get(position).getmInsideBeans()));
        }
    }

    @Override
    public int getItemCount() {
        return mOutBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView traySplitRv;
        private TextView trayType;
        private TextView trayNum;
        public ViewHolder(View itemView){
            super(itemView);
            traySplitRv = itemView.findViewById(R.id.tray_split_rv);
            trayType = itemView.findViewById(R.id.tray_type);
            trayNum = itemView.findViewById(R.id.tray_num);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.VERTICAL,false);
            traySplitRv.setLayoutManager(manager);
        }
    }
}
