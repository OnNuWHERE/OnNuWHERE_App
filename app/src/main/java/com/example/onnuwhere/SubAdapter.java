package com.example.onnuwhere;

import android.media.Image;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onnuwhere.model.Recycle;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.ViewHolder> {

    private List<Recycle> recycleList;
    private Recycle recycle;

    public SubAdapter(List<Recycle> recycleList) {
        this.recycleList = recycleList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView addrTitle, addrDistance, addrRaw, addrCategory;
        ImageView ImgPin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            addrTitle = (TextView) itemView.findViewById(R.id.addrTitle);
            addrCategory = (TextView) itemView.findViewById(R.id.addrCategory);
            addrRaw = (TextView) itemView.findViewById(R.id.addrRaw);
            addrDistance = (TextView) itemView.findViewById(R.id.addrDistance);
            ImgPin = (ImageView) itemView.findViewById(R.id.ImgPin);
        }
    }

    @NonNull
    @Override
    public SubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addr_list,parent,false);
        SubAdapter.ViewHolder sViewHolder = new SubAdapter.ViewHolder(view);
        return sViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Collections.sort(recycleList, Comparator.comparingDouble(Recycle::getDis));
        }
        recycle = recycleList.get(position);
        Log.d("sub","recycle:"+recycle);
        holder.addrTitle.setText(recycle.getTitle());
            holder.addrCategory.setText(recycle.getCategory());
            holder.addrRaw.setText(recycle.getAddress());
            if (recycle.getDis()<1){
                holder.addrDistance.setText(recycle.getDis()*1000+"m");
            }else {
                holder.addrDistance.setText(recycle.getDis()+"km");
            }
            if(recycle.getCategory().equals("지진대피소")){
                holder.ImgPin.setImageResource(R.drawable.earthquake_32);
            } else if(recycle.getCategory().equals("제세동기")) {
                holder.ImgPin.setImageResource(R.drawable.aed_32);
            } else if(recycle.getCategory().equals("민방공대피소")) {
                holder.ImgPin.setImageResource(R.drawable.shelter_32);
            } else {
                holder.ImgPin.setImageResource(R.drawable.tsunami_32);
            }
    }

    @Override
    public int getItemCount() {
        if(recycleList.size()<15){
          return recycleList.size();
        }else {
            return 15;
        }
    }
}
