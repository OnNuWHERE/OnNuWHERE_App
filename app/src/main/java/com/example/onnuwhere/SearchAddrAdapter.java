package com.example.onnuwhere;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.provider.CallLog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onnuwhere.model.Place;

import net.daum.mf.map.api.MapPoint;

import org.w3c.dom.Text;

import java.util.List;

public class SearchAddrAdapter extends RecyclerView.Adapter<SearchAddrAdapter.MyViewHolder> {
    private List<Place> placeList;
    private Place place;
    private Location location;

    private Context context;

    public SearchAddrAdapter(List<Place> placeList) {
        this.placeList = placeList;
    }

    public SearchAddrAdapter(List<Place> placeList, Context context) {

        this.placeList = placeList;
        this.context = context;
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
    public SearchAddrAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addr_list, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAddrAdapter.MyViewHolder holder, int position) {
        place = placeList.get(position);
        location = ((Search_View)Search_View.mContext).location;
        holder.addrTitle.setText(place.getPlace_name());
        holder.addrCategory.setText(place.getCategory_group_name());
        holder.addrRaw.setText(place.getAddress_name());
        if(calLocation(location.getLatitude(),location.getLongitude())>=1){
        holder.addrDistance.setText(
            String.valueOf(
                    calLocation(location.getLatitude(),location.getLongitude())+"km"));
        }else{
            holder.addrDistance.setText(
            String.valueOf(
                    calLocation(location.getLatitude(),location.getLongitude())*1000+"m"));
        }



        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "lol", Toast.LENGTH_SHORT).show();
                context = v.getContext();
                Intent intent_marker = new Intent(context, MainActivity.class);
                intent_marker.putExtra("x", place.getX());
                intent_marker.putExtra("y", place.getY());
                intent_marker.putExtra("placeName", place.getPlace_name());
                intent_marker.putExtra("ID", place.getId());
                context.startActivity(intent_marker);
                ((Activity)context).setResult(Activity.RESULT_OK);
                ((Activity)context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList==null?0:placeList.size();
    }




    public double calLocation(double gpsLat, double gpsLong){
        double place_long= Double.parseDouble(place.getX());
        double place_lat= Double.parseDouble(place.getY());
        return distance(place_lat,place_long,gpsLat,gpsLong,"K");
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
