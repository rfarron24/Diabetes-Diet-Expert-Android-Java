package com.example.rihaf.diabetesdietexpert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TemporaryActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary2);
    }

    public void Input(View v) {
        startActivity(new Intent(TemporaryActivity2.this, AdminInputFoodList.class));
    }


    public void Edit(View v) {
        startActivity(new Intent(TemporaryActivity2.this, AdminInputFoodList.class));
    }


    public void Delete(View v) {
        startActivity(new Intent(TemporaryActivity2.this, AdminInputFoodList.class));
    }
}
