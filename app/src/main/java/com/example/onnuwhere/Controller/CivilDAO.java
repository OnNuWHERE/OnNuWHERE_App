package com.example.onnuwhere.Controller;

import com.example.onnuwhere.model.Civil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class CivilDAO {
    ArrayList<Civil> CivilList = new ArrayList<Civil>();
    private DatabaseReference fbDataCivil;

    CivilDAO() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        fbDataCivil = db.getReference("Civil");
    }

    public Query findAll(DataSnapshot snapshot) {
        CivilList.clear();
        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
            Civil CivilData = dataSnapshot.getValue(Civil.class);
            CivilList.add(CivilData);
        }
        return fbDataCivil;
    }
}
