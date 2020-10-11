package com.example.hackutu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ComplaintList extends AppCompatActivity {

    private TextView nameText, ageText, address, pincode, email, subCategory, company, problem;

    private String name, age, emailId, pin, add, sub_category, prob, comp;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_list);

        inflate_layout();

        /*name = new ArrayList<>();
        age = new ArrayList<>();
        emailId = new ArrayList<>();
        pin = new ArrayList<>();
        add = new ArrayList<>();
        sub_category = new ArrayList<>();
        prob = new ArrayList<>();
        comp = new ArrayList<>();*/

        ref = FirebaseDatabase.getInstance().getReference().child("Complaint").child("Complaint1");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                name = snapshot.child("name").getValue().toString();
                add = snapshot.child("add").getValue().toString();
                age = snapshot.child("age").getValue().toString();
                emailId = snapshot.child("emailId").getValue().toString();
                pin = snapshot.child("pin").getValue().toString();
                sub_category = snapshot.child("sub_category").getValue().toString();
                prob = snapshot.child("prob").getValue().toString();
                comp = snapshot.child("comp").getValue().toString();

                setValues();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void setValues() {

        nameText.setText(name);
        address.setText(add);
        ageText.setText(age);
        pincode.setText(pin);
        problem.setText(prob);
        company.setText(comp);
        email.setText(emailId);
        subCategory.setText(sub_category);

    }

    private void inflate_layout()
    {
        nameText = findViewById(R.id.name_applicant);
        ageText = findViewById(R.id.age_applicant);
        address = findViewById(R.id.address);
        pincode = findViewById(R.id.pincode);
        email= findViewById(R.id.email);
        subCategory = findViewById(R.id.sub_category);
        problem = findViewById(R.id.problem);
        company = findViewById(R.id.company);
    }

}