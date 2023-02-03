package com.example.onnuwhere.Controller;

import com.example.onnuwhere.model.Civil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class CivilDAO {
    private DatabaseReference fbDataCivil;

    public CivilDAO() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        fbDataCivil = db.getReference("Civil");
    }

    public Query findAll(DataSnapshot snapshot) {
        return fbDataCivil;
    }
}
