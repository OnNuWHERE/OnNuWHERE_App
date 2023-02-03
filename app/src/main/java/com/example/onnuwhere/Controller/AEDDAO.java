package com.example.onnuwhere.Controller;

import com.example.onnuwhere.model.AED;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class AEDDAO {
    private DatabaseReference fbDataAED;

    public AEDDAO() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        fbDataAED = db.getReference("AED");
    }

    //MainActivity.java 에서 Query.addValueEventListener(new ValueEventListener() > Override
    public Query findAll() {
        return fbDataAED;
    }
}
