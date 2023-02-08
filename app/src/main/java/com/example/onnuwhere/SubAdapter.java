package com.example.onnuwhere;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onnuwhere.model.DataPage;
import com.example.onnuwhere.model.Recycle;

import java.util.List;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.ViewHolder> {

    private List<Recycle> recycleList;
    private Recycle recycle;

    public SubAdapter(List<Recycle> recycleList) {
        this.recycleList = recycleList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView addrTitle, addrDistance, addrRaw, addrCategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            addrTitle = (TextView) itemView.findViewById(R.id.addrTitle);
            addrCategory = (TextView) itemView.findViewById(R.id.addrCategory);
            addrRaw = (TextView) itemView.findViewById(R.id.addrRaw);
            addrDistance = (TextView) itemView.findViewById(R.id.addrDistance);
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
    public void onBindViewHolder(@NonNull SubAdapter.ViewHolder holder, int position) {
        recycle = recycleList.get(position);
        double lat = ((MainActivity)MainActivity.mContext)
                .mView.getMapCenterPoint().getMapPointGeoCoord().latitude;
        double lon = ((MainActivity)MainActivity.mContext)
                .mView.getMapCenterPoint().getMapPointGeoCoord().longitude;
        double dis = distance(recycle.getLat(),recycle.getLon(),lat,lon,"K");
        if(dis*1000<=5000) {
            holder.addrTitle.setText(recycle.getTitle());
            holder.addrCategory.setText(recycle.getCategory());
            holder.addrRaw.setText(recycle.getAddress());
            holder.addrDistance.setText(String.valueOf(dis));
        }
    }

    @Override
    public int getItemCount() {
        return recycleList==null?0:recycleList.size();
    }

    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (Math.round(Math.abs(dist)));
        }
    }
}
