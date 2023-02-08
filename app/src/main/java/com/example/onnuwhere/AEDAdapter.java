package com.example.onnuwhere;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onnuwhere.model.AED;
import com.example.onnuwhere.model.TsunamiShelter;

import java.util.ArrayList;

public class AEDAdapter extends RecyclerView.Adapter<AEDAdapter.MyViewHolder> {

    private MainActivity mContext;

    private AED aed;



    private ArrayList<AED> aedArrayList;

    AEDAdapter(ArrayList<AED> aedArrayList) {
        this.aedArrayList = aedArrayList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView addrTitle, addrDistance, addrRaw, addrCategory;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            addrTitle = (TextView) itemView.findViewById(R.id.addrTitle);
            addrCategory = (TextView) itemView.findViewById(R.id.addrCategory);
            addrRaw = (TextView) itemView.findViewById(R.id.addrRaw);
            addrDistance = (TextView) itemView.findViewById(R.id.addrDistance);
        }
    }
    @NonNull
    @Override
    public AEDAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addr_list, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AEDAdapter.MyViewHolder holder, int position) {
        aed = aedArrayList.get(position);
        double lat = ((MainActivity)MainActivity.mContext)
                .mView.getMapCenterPoint().getMapPointGeoCoord().latitude;
        double lon = ((MainActivity)MainActivity.mContext)
                .mView.getMapCenterPoint().getMapPointGeoCoord().longitude;
        double dis = distance(aed.getLat(),aed.getLon(),lat,lon,"K");
        if(dis*1000<=5000){
            holder.addrTitle.setText(aed.getTitle());
            holder.addrCategory.setText("제세동기");
            holder.addrRaw.setText(aed.getBuildAddress()+" "+aed.getBuildPlace());

            holder.addrDistance.setText(String.valueOf(dis));
        }
    }

    @Override
    public int getItemCount() {
        return aedArrayList==null?0:aedArrayList.size();
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
