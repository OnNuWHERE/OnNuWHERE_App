package com.example.onnuwhere;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onnuwhere.model.AED;
import com.example.onnuwhere.model.Civil;
import com.example.onnuwhere.model.DataPage;
import com.example.onnuwhere.model.EarthquakeOutdoorsShelter;
import com.example.onnuwhere.model.Recycle;
import com.example.onnuwhere.model.TsunamiShelter;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<DataPage> dataPageList;
    private DataPage dataPage;

    public MainAdapter(List<DataPage> dataPageList) {
        this.dataPageList = dataPageList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
       private RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.subRecycler);
        }
    }
    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_slide, parent, false);
        MainAdapter.ViewHolder viewHolder = new MainAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
    dataPage = dataPageList.get(position);

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.recyclerView.getContext(),LinearLayoutManager.VERTICAL,false);
        layoutManager.setInitialPrefetchItemCount(dataPage.getRecycleList().size());

        SubAdapter subAdapter = new SubAdapter(dataPage.getRecycleList());
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(subAdapter);
        holder.recyclerView.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return dataPageList==null?0:dataPageList.size();
    }
}
