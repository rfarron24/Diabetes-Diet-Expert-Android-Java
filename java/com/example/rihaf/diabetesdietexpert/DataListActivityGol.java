package com.example.rihaf.diabetesdietexpert;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DataListActivityGol extends AppCompatActivity {
    ListView listView2;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper userDbHelper;
    Cursor cursor;

    ListDataAdaptergol listDataAdaptergol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_gol);
        listView2 = (ListView) findViewById(R.id.list_view);
        listDataAdaptergol = new ListDataAdaptergol(getApplicationContext(), R.layout.row_layoutgol);
        listView2.setAdapter(listDataAdaptergol);
        userDbHelper = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();



//-------------- BELOW TO SHOW DAILYCALORIE CONTENT TO TEXTVIEW ---------------------//
        String caloriez = userDbHelper.getDailyCalorie();
        TextView textdailykalori = (TextView) findViewById(R.id.txt_dailykal2);

        textdailykalori.setText(caloriez.toString());

//-------------- BELOW TO DETERMINTE GOLONGAN DIET NUMBER BASED ON DAILY CALORIC INTAKE FROM ABOVE TEXTVIEW--------//
        TextView golongan = (TextView) findViewById(R.id.txt_gol);

        double dailycal = Double.parseDouble(textdailykalori.getText().toString());

        if (dailycal >= 1100 && dailycal < 1300 )
            golongan.setText("1");
        else
        if (dailycal >= 1300 && dailycal < 1500 )
            golongan.setText("2");
        else
        if (dailycal >= 1500 && dailycal < 1700 )
            golongan.setText("3");
        else
        if (dailycal >= 1700 && dailycal < 1900 )
            golongan.setText("4");
        else
        if (dailycal >= 1900 && dailycal < 2100 )
            golongan.setText("5");
        else
        if (dailycal >= 2100 && dailycal < 2300 )
            golongan.setText("6");
        else
        if (dailycal >= 2300 && dailycal < 2500 )
            golongan.setText("7");
        else
        if (dailycal >= 2500 )
            golongan.setText("8");

//-------------- BELOW TO SHOW DETERMINE WHICH GOL_DIET TABLE TO CALL ACCORDING TO GOLONGAN DIET NUMBER ABOVE-----------------//

   //     int golongan1 = Integer.parseInt(golongan.getText().toString());



    //    if (golongan1 == 3)
     //       cursor = userDbHelper.getInformations1500(sqLiteDatabase);
     //   else
      //      if (golongan1 == 2)

        //        cursor = userDbHelper.getInformations1300(sqLiteDatabase);
        //   else
         //   if (golongan1 == 4)

          //      cursor = userDbHelper.getInformations1700(sqLiteDatabase);
         //   else
        //    if (golongan1 == 5)

         //       cursor = userDbHelper.getInformations1900(sqLiteDatabase);
        //    else
        //    if (golongan1 == 6)

         //       cursor = userDbHelper.getInformations2100(sqLiteDatabase);
        //    else
        //    if (golongan1 == 7)

         //       cursor = userDbHelper.getInformations2300(sqLiteDatabase);
        //    else
         //   if (golongan1 == 8)

        //        cursor = userDbHelper.getInformations2500(sqLiteDatabase);
         //   else
         //   if (golongan1 == 1)

       //         cursor = userDbHelper.getInformations1100(sqLiteDatabase);


        TextView GOLDIET = (TextView)findViewById(R.id.txt_gol);
        String goldietno = GOLDIET.getText().toString();

        cursor = userDbHelper.getGolonganDiet(goldietno);

//-------------- BELOW IS TO CALL DETERMINED DIET MENU TABLE  ACCORDING TO FUNCTION ABOVE AND SHOW THE ARRAY TO THE LISTVIEW-----------------//

                if (cursor.moveToFirst()) {
                    do {

                        String mealtime, calorie, carbo, protein, veggie, fruit, milk;
                        mealtime = cursor.getString(0);
                        calorie = cursor.getString(1);
                        carbo = cursor.getString(2);
                        protein = cursor.getString(3);
                        veggie = cursor.getString(4);
                        fruit = cursor.getString(5);
                        milk = cursor.getString(6);
                        DataProvidergol dataProvidergol = new DataProvidergol(mealtime, calorie, carbo, protein, veggie, fruit, milk);
                        listDataAdaptergol.add(dataProvidergol);
                    }
                    while (cursor.moveToNext());
                }


            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_id:
                startActivity(new Intent (DataListActivityGol.this, dietplan2Activity.class));
            default:
                return super.onOptionsItemSelected(item);

        }}



    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(DataListActivityGol.this, MainActivity.class));
        finish();

    }

        }

