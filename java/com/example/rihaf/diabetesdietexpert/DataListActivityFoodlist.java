package com.example.rihaf.diabetesdietexpert;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class DataListActivityFoodlist extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper userDbHelper;
    Cursor cursor;
    ListDataAdapterFood listDataAdapterFood;

public final static String ID_EXTRA="com.example.rihaf.diabetesdietexpert_ID9";
   // public final static String F_NAME="com.example.rihaf.diabetesdietexpert.DataListActivityFoodlist_FOOD";
   // public final static String F_PORTION="com.example.rihaf.diabetesdietexpert_PORTION";
  //  public final static String F_CAL="com.example.rihaf.diabetesdietexpert_CALORIE";

    String FoodNameS, PortionS, CalorieS, MealTIME, KALGRAM, PROS, FATS, CARBS, CurrentCal,CalGolDiets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layoutfood);
        listView = (ListView) findViewById(R.id.list_view_food);
        userDbHelper = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        cursor = userDbHelper.getFoodList(sqLiteDatabase);
        listDataAdapterFood = new ListDataAdapterFood(getApplicationContext(),R.layout.row_layout_food);
        listView.setAdapter(listDataAdapterFood);

        TextView  mealtime = (TextView)findViewById(R.id.txt_mealtime2);
        mealtime.setText(getIntent().getStringExtra("MEALTIME"));


        TextView  currentkalori = (TextView)findViewById(R.id.currentcal);

        currentkalori.setText(getIntent().getStringExtra("CURRENTCAL"));

        TextView  kalgoldiets = (TextView)findViewById(R.id.kalgoldiet);

        kalgoldiets.setText(getIntent().getStringExtra("CALGOLDIET"));

            if(cursor.moveToFirst())
        {
            do{

                String  name,  porsi, proteincontent,  fatcontent,  carbcontent;
                Double porsikal,gramkal;

                name = cursor.getString(0);
                porsi = cursor.getString(1);

                porsikal = cursor.getDouble(2);
                gramkal = cursor.getDouble(3);

                proteincontent = cursor.getString(4);
                fatcontent = cursor.getString(5);
                carbcontent = cursor.getString(6);

                //MEMANGGIL DARI CLASS DataProvider.Java//
                DataProviderFoodlist dataProviderFoodlist = new DataProviderFoodlist(name, porsi, porsikal, gramkal, proteincontent, fatcontent, carbcontent);
                listDataAdapterFood.add(dataProviderFoodlist);


                //---------------------------------- BELOW IS THE FUNCTION OF CLICKED LIST--------------------------------------------------//
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                  //  Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+"Is Selected", Toast.LENGTH_LONG).show();
                        view.setSelected(true);
                        TextView  mltm = (TextView)findViewById(R.id.txt_mealtime2);
                     MealTIME = mltm.getText().toString();

                        TextView  currentcalorie = (TextView)findViewById(R.id.currentcal);
                        CurrentCal = currentcalorie.getText().toString();

                        TextView  CalGolDiettxt = (TextView)findViewById(R.id.kalgoldiet);
                        CalGolDiets = CalGolDiettxt.getText().toString();


                        if ((mltm.getText().toString().length() == 0 )){
                            Toast.makeText(DataListActivityFoodlist.this, "Waktu Makan Belum Ditentukan", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(DataListActivityFoodlist.this, dietplan2Activity.class));
                        }



                        else{

                      Intent i = new Intent(DataListActivityFoodlist.this, JournalDiet.class);

                     i.putExtra(ID_EXTRA, String.valueOf(id));
                       i.putExtra("MLTM", MealTIME);
                            i.putExtra("CURRENTCAL",CurrentCal);
                            i.putExtra("CALGOLDIET",CalGolDiets);
                      startActivity(i);
                    }}
                });


            }
            while (cursor.moveToNext());
        }


    }

    public void ClickAdd (View v) {

        TextView  mltm = (TextView)findViewById(R.id.txt_mealtime2);
        MealTIME = mltm.getText().toString();

        TextView  currentcalorie = (TextView)findViewById(R.id.currentcal);
        CurrentCal = currentcalorie.getText().toString();

        TextView  CalGolDiettxt = (TextView)findViewById(R.id.kalgoldiet);
        CalGolDiets = CalGolDiettxt.getText().toString();

        Intent i = new Intent(DataListActivityFoodlist.this, UserAddFoodlistActivity.class);


        i.putExtra("MLTM", MealTIME);
        i.putExtra("CURRENTCAL",CurrentCal);
        i.putExtra("CALGOLDIET",CalGolDiets);

        startActivity(i);


    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(DataListActivityFoodlist.this, MainActivity.class));
        finish();

    }

        }


