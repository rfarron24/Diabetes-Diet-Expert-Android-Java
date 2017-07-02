package com.example.rihaf.diabetesdietexpert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TemporaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary);

        Button buttonnew = (Button) findViewById(R.id.button_new);

//---------------------------------------START OF : MAIN BUTTON METHOD-----------------------------------------------//
        buttonnew.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent (TemporaryActivity.this, MainActivity.class));
            }
        });
    }
    public void viewGol (View view){
        Intent intent = new Intent(this,DataListActivityGol.class);
        startActivity(intent);
    }
}
