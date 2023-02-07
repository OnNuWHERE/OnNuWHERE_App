package com.example.onnuwhere;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onnuwhere.model.AED;
import com.example.onnuwhere.model.Civil;
import com.example.onnuwhere.model.DataPage;
import com.example.onnuwhere.model.EarthquakeOutdoorsShelter;
import com.example.onnuwhere.model.TsunamiShelter;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<DataPage> dataPageList;

    private List<Civil> civilList;
    private List<EarthquakeOutdoorsShelter> earthquakeOutdoorsShelterList;
    private List<AED> aedList;
    private List<TsunamiShelter> tsunamiShelterList;


    public MainAdapter(List<DataPage> dataPageList) {
        this.dataPageList = dataPageList;
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
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addr_list, parent, false);
        MainAdapter.ViewHolder viewHolder = new MainAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return dataPageList==null?0:dataPageList.size();
    }
}
