package com.example.onnuwhere.Controller;

import com.example.onnuwhere.model.EarthquakeOutdoorsShelter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class EOSDAO {
    private DatabaseReference fbDataEOS;

    public EOSDAO() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        fbDataEOS = db.getReference("EarthquakeOutdoorsShelter");
    }

    //MainActivity.java 에서 Query.addValueEventListener(new ValueEventListener() > Override
    public Query findAll(DataSnapshot snapshot) {
        return fbDataEOS;
    }
}
