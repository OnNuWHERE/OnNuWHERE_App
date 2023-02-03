package com.example.onnuwhere.Controller;

import com.example.onnuwhere.model.AED;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class AEDDAO {
    ArrayList<AED> AEDList = new ArrayList<AED>();
    private DatabaseReference fbDataAED;

    AEDDAO() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        fbDataAED = db.getReference("AED");
    }

    //MainActivity.java 에서 Query.addValueEventListener(new ValueEventListener() > Override
    public Query findAll(DataSnapshot snapshot) {
        AEDList.clear();
        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
            AED AEDData = dataSnapshot.getValue(AED.class);
            AEDList.add(AEDData);
        }
        return fbDataAED;
    }
}
