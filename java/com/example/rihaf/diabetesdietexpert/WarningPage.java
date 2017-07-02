package com.example.rihaf.diabetesdietexpert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WarningPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning_page);
        Button backbtn = (Button) findViewById(R.id.back);
    }
    public void backtojournal (View v) {
        startActivity(new Intent(WarningPage.this, dietplan2Activity.class));
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(WarningPage.this, dietplan2Activity.class));
        finish();

    }
    }

