package com.example.rihaf.diabetesdietexpert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserAddFoodlistActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    String FoodNameS, PortionS, CalorieS, MealTIME, KALGRAM, PROS, FATS, CARBS, CurrentCal,CalGolDiets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add_foodlist);
        myDb = new DatabaseHelper(this);

        TextView mealtime = (TextView)findViewById(R.id.mealtime3);
        mealtime.setText(getIntent().getStringExtra("MLTM"));


        TextView  currentkalori = (TextView)findViewById(R.id.currentcal3);

        currentkalori.setText(getIntent().getStringExtra("CURRENTCAL"));

        TextView  kalgoldiets = (TextView)findViewById(R.id.calgoldiet3);

        kalgoldiets.setText(getIntent().getStringExtra("CALGOLDIET"));
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.cancel_id:
                Toast.makeText(UserAddFoodlistActivity.this, "Tambah Data Dibatalkan", Toast.LENGTH_LONG).show();
                startActivity(new Intent (UserAddFoodlistActivity.this, dietplan2Activity.class));

                return super.onOptionsItemSelected(item);

            case R.id.save_id:

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


                EditText foodname2 = (EditText)findViewById(R.id.calendartxt);
                EditText ukuranporsi = (EditText)findViewById(R.id.txt_portion);
                EditText calorieportion2 = (EditText) findViewById(R.id.txt_portioncal);




                if (foodname2.getText().toString().length() == 0)  {
                    Toast.makeText(UserAddFoodlistActivity.this, "Nama Makanan Harus Diisi", Toast.LENGTH_LONG).show();

                }
                else
                if (ukuranporsi.getText().toString().length() == 0)  {
                    Toast.makeText(UserAddFoodlistActivity.this, "Ukuran Porsi Harus Diisi", Toast.LENGTH_LONG).show();

                }

                else
                        if (calorieportion2.getText().toString().length() == 0)  {
                            Toast.makeText(UserAddFoodlistActivity.this, "Kalori Harus Diisi", Toast.LENGTH_LONG).show();

                        }



                    else {

                            //---------------------AWAL : INSERT DATA INPUT TO DATABASE SQLite--------------------------------------------//
                            boolean isInserted = myDb.insertDataFoodlist(namamakanan, porsi, kaloriperporsi, kaloripergram, protein, lemak, karbohidrat);
                            if (isInserted = true)
                                Toast.makeText(UserAddFoodlistActivity.this, "DATA TELAH DISIMPAN", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(UserAddFoodlistActivity.this, "DATA GAGAL DISIMPAN", Toast.LENGTH_LONG).show();
                            //---------------------AKHIR : INSERT DATA INPUT TO DATABASE SQLite--------------------------------------------//
                            TextView  mltm = (TextView)findViewById(R.id.mealtime3);
                            MealTIME = mltm.getText().toString();

                            TextView  currentcalorie = (TextView)findViewById(R.id.currentcal3);
                            CurrentCal = currentcalorie.getText().toString();

                            TextView  CalGolDiettxt = (TextView)findViewById(R.id.calgoldiet3);
                            CalGolDiets = CalGolDiettxt.getText().toString();


                            Intent i = new Intent(UserAddFoodlistActivity.this, DataListActivityFoodlist.class);
                            i.putExtra("MEALTIME", MealTIME);
                            i.putExtra("CURRENTCAL", CurrentCal);
                            i.putExtra("CALGOLDIET", CalGolDiets);
                            startActivity(i);
                        }

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
