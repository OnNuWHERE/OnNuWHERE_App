package com.example.onnuwhere.Controller;

import com.example.onnuwhere.model.EarthquakeOutdoorsShelter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class EOSDAO {
    ArrayList<EarthquakeOutdoorsShelter> List = new ArrayList<EarthquakeOutdoorsShelter>();
    private DatabaseReference fbDataEOS;

    EOSDAO() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        fbDataEOS = db.getReference("EarthquakeOutdoorsShelter");
    }

    public Query findAll(DataSnapshot snapshot) {
        List.clear();
        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
             EarthquakeOutdoorsShelter EOSData = dataSnapshot.getValue(EarthquakeOutdoorsShelter.class);
            List.add(EOSData);
        }
        return fbDataEOS;
    }
}
