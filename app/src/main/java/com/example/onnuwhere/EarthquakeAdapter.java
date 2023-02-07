package com.example.onnuwhere;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onnuwhere.model.EarthquakeOutdoorsShelter;

import java.util.ArrayList;

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.MyViewHolder>{

    private EarthquakeOutdoorsShelter earthquakeOutdoorsShelter;

    private ArrayList<EarthquakeOutdoorsShelter> earthquakeOutdoorsShelterList;

    public EarthquakeAdapter(ArrayList<EarthquakeOutdoorsShelter> earthquakeOutdoorsShelterList) {
        this.earthquakeOutdoorsShelterList = earthquakeOutdoorsShelterList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addr_list, parent, false);
        EarthquakeAdapter.MyViewHolder viewHolder = new EarthquakeAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        earthquakeOutdoorsShelter = earthquakeOutdoorsShelterList.get(position);
        double lat = ((MainActivity)MainActivity.mContext)
                .mView.getMapCenterPoint().getMapPointGeoCoord().latitude;
        double lon = ((MainActivity)MainActivity.mContext)
                .mView.getMapCenterPoint().getMapPointGeoCoord().longitude;
        double dis = distance(earthquakeOutdoorsShelter.getYcord(),
                earthquakeOutdoorsShelter.getXcord(),lat,lon,"K");
        if(dis*1000<=5000){
            holder.addrTitle.setText(earthquakeOutdoorsShelter.getVt_acmdfclty_nm());
            holder.addrCategory.setText("지진대피소");
            holder.addrRaw.setText(earthquakeOutdoorsShelter.getDtl_adres());
            if(dis<2){
                holder.addrDistance.setText((dis*0.001)+"m");
            }else {
                holder.addrDistance.setText(dis+"km");
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(((MainActivity) MainActivity.mContext).getApplicationContext(), ""+earthquakeOutdoorsShelter.getVt_acmdfclty_nm(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return earthquakeOutdoorsShelterList==null?0:earthquakeOutdoorsShelterList.size();
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
