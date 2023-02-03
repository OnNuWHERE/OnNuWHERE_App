package com.example.onnuwhere.Controller;

import com.example.onnuwhere.model.TsunamiShelter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class TSDAO {
    ArrayList<TsunamiShelter> List = new ArrayList<TsunamiShelter>();
    private DatabaseReference fbDataTS;

    TSDAO() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        fbDataTS = db.getReference("TsunamiShelter");
    }

    public Query findAll(DataSnapshot snapshot) {
        List.clear();
        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
             TsunamiShelter TSData = dataSnapshot.getValue(TsunamiShelter.class);
            List.add(TSData);
        }
        return fbDataTS;
    }
}
