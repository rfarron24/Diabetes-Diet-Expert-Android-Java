package com.example.rihaf.diabetesdietexpert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminInputFoodList extends AppCompatActivity {
    DatabaseHelper myDb;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_input_food_list);
        myDb = new DatabaseHelper(this);
        addListenerOnButton3();


    }

    public void addListenerOnButton3() {

        button1 = (Button) findViewById(R.id.button_savefood);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                EditText foodname = (EditText)findViewById(R.id.calendartxt); //1
                EditText portion = (EditText)findViewById(R.id.txt_portion); //2
                EditText calorieportion = (EditText) findViewById(R.id.txt_portioncal); //3
                EditText caloriegram = (EditText) findViewById(R.id.txt_gramportion); //4
                EditText proteinfood = (EditText)findViewById(R.id.txt_proteinfood); //5
                EditText fatfood = (EditText) findViewById(R.id.txt_fatfood); //6
                EditText carbfood = (EditText)findViewById(R.id.txt_carbfood); //7

                String namamakanan = foodname.getText().toString();
                String porsi = portion.getText().toString();
                String kaloriperporsi = calorieportion.getText().toString();
                String kaloripergram = caloriegram.getText().toString();
                String protein = proteinfood.getText().toString();
                String lemak = fatfood.getText().toString();
                String karbohidrat = carbfood.getText().toString();



                //---------------------AWAL : INSERT DATA INPUT TO DATABASE SQLite--------------------------------------------//
                boolean isInserted =  myDb.insertDataFoodlist(namamakanan,porsi,kaloriperporsi,kaloripergram,protein,lemak,karbohidrat);
                if(isInserted =true)
                    Toast.makeText(AdminInputFoodList.this,"DATA TELAH DISIMPAN", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AdminInputFoodList.this,"DATA GAGAL DISIMPAN", Toast.LENGTH_LONG).show();
                //---------------------AKHIR : INSERT DATA INPUT TO DATABASE SQLite--------------------------------------------//

                startActivity(new Intent(AdminInputFoodList.this, TemporaryActivity2.class));

            }


        });
    }

    public void UpdateFood(View v) {

        EditText idfood  = (EditText)findViewById(R.id.txt_idfood);
        EditText foodname = (EditText)findViewById(R.id.calendartxt); //1
        EditText portion = (EditText)findViewById(R.id.txt_portion); //2
        EditText calorieportion = (EditText) findViewById(R.id.txt_portioncal); //3
        EditText caloriegram = (EditText) findViewById(R.id.txt_gramportion); //4
        EditText proteinfood = (EditText)findViewById(R.id.txt_proteinfood); //5
        EditText fatfood = (EditText) findViewById(R.id.txt_fatfood); //6
        EditText carbfood = (EditText)findViewById(R.id.txt_carbfood); //7

        String id9 = idfood.getText().toString();
        String namamakanan = foodname.getText().toString();
        String porsi = portion.getText().toString();
        String kaloriperporsi = calorieportion.getText().toString();
        String kaloripergram = caloriegram.getText().toString();
        String protein = proteinfood.getText().toString();
        String lemak = fatfood.getText().toString();
        String karbohidrat = carbfood.getText().toString();



        //---------------------AWAL : INSERT DATA INPUT TO DATABASE SQLite--------------------------------------------//
        boolean isUpdate =  myDb.updateDataFoodlist(id9,namamakanan,porsi,kaloriperporsi,kaloripergram,protein,lemak,karbohidrat);
        if(isUpdate =true)
            Toast.makeText(AdminInputFoodList.this,"DATA TELAH DISIMPAN", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(AdminInputFoodList.this,"DATA GAGAL DISIMPAN", Toast.LENGTH_LONG).show();
        //---------------------AKHIR : INSERT DATA INPUT TO DATABASE SQLite--------------------------------------------//

        startActivity(new Intent(AdminInputFoodList.this, TemporaryActivity2.class));

    }

}
