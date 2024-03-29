package com.example.onnuwhere;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchAddrAdapter extends RecyclerView.Adapter<SearchAddrAdapter.MyViewHolder> {
    private List<Place> placeList;
    private Place place;
    private Location location;

    private Context context;

    private SearchListener searchListener;

    public void setSearchListener(SearchListener searchListener) {
        this.searchListener = searchListener;
    }


    public SearchAddrAdapter(List<Place> placeList) {
        this.placeList = placeList;
    }

    public SearchAddrAdapter(List<Place> placeList, Context context) {

        this.placeList = placeList;
        this.context = context;
    }

    public Place getItem(int position) {
        Place p = placeList.get(position);
        return p;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Collections.sort(placeList, Comparator.comparingInt(Place::getDistance));
        }
        place = placeList.get(position);
        location = ((Search_View)Search_View.mContext).location;
        holder.addrTitle.setText(place.getPlace_name());
        holder.addrCategory.setText(place.getCategory_group_name());
        holder.addrRaw.setText(place.getAddress_name());
        double distance =place.getDistance();
        if(distance>1000) {
            holder.addrDistance.setText(Math.round(distance*0.001)+"km");
        } else {
            holder.addrDistance.setText(Math.round(distance)+"m");
        }



//        if(calLocation(location.getLatitude(),location.getLongitude())>=1){
//        holder.addrDistance.setText(
//            String.valueOf(
//                    calLocation(location.getLatitude(),location.getLongitude())+"km"));
//        }else{
//            holder.addrDistance.setText(
//            String.valueOf(
//                    calLocation(location.getLatitude(),location.getLongitude())*1000+"m"));
//        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "lol", Toast.LENGTH_SHORT).show();
                int pos = holder.getAdapterPosition();
                searchListener.SearchItemClick(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList==null?0:placeList.size();
    }





}
