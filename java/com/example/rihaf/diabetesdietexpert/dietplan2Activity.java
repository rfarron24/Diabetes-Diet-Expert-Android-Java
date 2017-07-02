package com.example.rihaf.diabetesdietexpert;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.text.SimpleDateFormat;

public class dietplan2Activity extends AppCompatActivity {
    FloatingActionButton fab, fab_breakfast, fab_lunch2, fab_dinner, fab_snack;
    TextView textViewBreakfast, textViewLunch, textViewDinner, textViewSnack;

    ListView list_view_journal;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper userDbHelper;
    Cursor cursor;

    ListDataAdapterJournal listDataAdapterJournal;

    Animation FabOpen, FabClose, FabRClockwise, FabRantiClockwise;
    boolean isOpen=false;
    public final static String ID_EXTRA="com.example.rihaf.diabetesdietexpert_ID20";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietplan2);
        list_view_journal = (ListView) findViewById(R.id.list_view_journal);
        userDbHelper = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();



        //-------  BELOW IS THE INVISIBLE NUMERICAL CURRENT DATE,MONTH,YEAR FORMAT TO COUNT TOTAL CALORIE FOR THE DAY ---------//
        TextView calendar = (TextView) findViewById(R.id.txt_date2);


        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("Mdyyyy");
        String dateString = sdf.format(date);
        calendar.setText(dateString);


//--------------------------------  BELOW IS THE VISIBLE CURRENT DATE,MONTH,YEAR -----------------------------------------//
        TextView calendarView = (TextView) findViewById(R.id.calendar2);


        long date2 = System.currentTimeMillis();

        SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd yyyy");
        String dateString2 = sdf2.format(date2);
        calendarView.setText(dateString2);

//--------------------------------  BELOW IS THE VISIBLE CURRENT DATE,MONTH,YEAR -----------------------------------------//

        TextView Datelog1 = (TextView)findViewById(R.id.txt_date2);
        String DateLog1 = Datelog1.getText().toString();

        cursor = userDbHelper.getJournalDiet3(DateLog1);
        listDataAdapterJournal = new ListDataAdapterJournal(getApplicationContext(), R.layout.row_layout_journal);
        list_view_journal.setAdapter(listDataAdapterJournal);



        if (cursor.moveToFirst())

        {
            do {
                String waktumakan, jenismakan, porsimakan, qty;
                Double kalorimakan, total;

                waktumakan = cursor.getString(0);
                jenismakan = cursor.getString(1);
                porsimakan = cursor.getString(2);
                kalorimakan = cursor.getDouble(3);
                qty = cursor.getString(4);
                total = cursor.getDouble(5);

                //MEMANGGIL DARI CLASS DataProvider.Java//
                dataProviderJournal dataProviderJournals = new dataProviderJournal(waktumakan, jenismakan, porsimakan, kalorimakan, qty, total);
                listDataAdapterJournal.add(dataProviderJournals);


//---------------------------------- BELOW IS THE FUNCTION OF CLICKED LIST--------------------------------------------------//
                list_view_journal.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        view.setSelected(true);


                        TextView IntialCal = (TextView)findViewById(R.id.txt_dailykal2);
                        TextView ConsumedCal = (TextView)findViewById(R.id.txt_sisakalori);


                        String CurrentCal = ConsumedCal.getText().toString();
                        String CalGolDiet = IntialCal.getText().toString();

                        Intent i = new Intent(dietplan2Activity.this, JournalDiet2.class);


                        i.putExtra(ID_EXTRA, String.valueOf(id));
                        i.putExtra("CURRENTCAL",CurrentCal);
                        i.putExtra("CALGOLDIET",CalGolDiet);
                        startActivity(i);

                    }
                });
            }
            while (cursor.moveToNext());

        }



        //-------------- BELOW TO SHOW DAILYCALORIE CONTENT TO TEXTVIEW ---------------------//
        String caloriez = userDbHelper.getDailyCalorie();

        TextView textdailykalori = (TextView) findViewById(R.id.txt_dailykal2);

        textdailykalori.setText(caloriez.toString());

        //-----------------------BELOW COUNTING THE TOTAL CALORIC CONSUMPTION FOR THE DAY ---------------//


        TextView DateShow = (TextView)findViewById(R.id.txt_date2);
        String tanggals = DateShow.getText().toString();
        //int tanggals = Integer.parseInt(DateShow.getText().toString());

        //    double num1 = Double.parseDouble(e1.getText().toString());
        Integer CountKal = userDbHelper.getRemainingCalorie(tanggals);

        TextView sisakalori = (TextView) findViewById(R.id.txt_sisakalori);
        sisakalori.setText(CountKal.toString());


//--------------------- BELOW IS THE ANIMATION METHOD FOR FLOATING ACTION BUTTON -----------------//

        //ACTION FLOATING BUTTON VARIABLE//
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab_breakfast = (FloatingActionButton) findViewById(R.id.fab_breakfast);
        fab_lunch2 = (FloatingActionButton) findViewById(R.id.fab_lunch2);
        fab_dinner = (FloatingActionButton) findViewById(R.id.fab_dinner);
        fab_snack = (FloatingActionButton) findViewById(R.id.fab_snack);
        textViewBreakfast = (TextView) findViewById(R.id.textViewBreakfast);
        textViewLunch = (TextView) findViewById(R.id.textViewLunch);
        textViewDinner = (TextView) findViewById(R.id.textViewDinner);
        textViewSnack = (TextView) findViewById(R.id.textViewSnack);

        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabRantiClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        fab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (isOpen) {
                    fab_lunch2.startAnimation(FabClose);
                    fab_breakfast.startAnimation(FabClose);
                    fab_dinner.startAnimation(FabClose);
                    fab_snack.startAnimation(FabClose);

                    textViewBreakfast.startAnimation(FabClose);
                    textViewLunch.startAnimation(FabClose);
                    textViewDinner.startAnimation(FabClose);
                    textViewSnack.startAnimation(FabClose);

                    fab.startAnimation(FabRantiClockwise);
                    fab_breakfast.setClickable(false);
                    fab_lunch2.setClickable(false);
                    fab_dinner.setClickable(false);
                    fab_snack.setClickable(false);

                    textViewBreakfast.setClickable(false);
                    textViewLunch.setClickable(false);
                    textViewDinner.setClickable(false);
                    textViewSnack.setClickable(false);

                    isOpen = false;
                } else

                {
                    fab_lunch2.startAnimation(FabOpen);
                    fab_breakfast.startAnimation(FabOpen);
                    fab_dinner.startAnimation(FabOpen);
                    fab_snack.startAnimation(FabOpen);

                    textViewBreakfast.startAnimation(FabOpen);
                    textViewLunch.startAnimation(FabOpen);
                    textViewDinner.startAnimation(FabOpen);
                    textViewSnack.startAnimation(FabOpen);

                    fab.startAnimation(FabRClockwise);
                    fab_breakfast.setClickable(true);
                    fab_lunch2.setClickable(true);
                    fab_dinner.setClickable(true);
                    fab_snack.setClickable(true);

                    textViewBreakfast.setClickable(true);
                    textViewLunch.setClickable(true);
                    textViewDinner.setClickable(true);
                    fab_snack.setClickable(true);

                    isOpen = true;
                }
            }
        });

    }

    public void SarapanClick(View v) {

        TextView IntialCal = (TextView)findViewById(R.id.txt_dailykal2);
        TextView ConsumedCal = (TextView)findViewById(R.id.txt_sisakalori);

        String MealTime = textViewBreakfast.getText().toString();
        String CurrentCal = ConsumedCal.getText().toString();
        String CalGolDiet = IntialCal.getText().toString();

        Intent i = new Intent(dietplan2Activity.this, DataListActivityFoodlist.class);


        i.putExtra("MEALTIME",MealTime);
        i.putExtra("CURRENTCAL",CurrentCal);
        i.putExtra("CALGOLDIET",CalGolDiet);
        startActivity(i);

// }
    }

    public void LunchClick (View v) {

        TextView IntialCal = (TextView)findViewById(R.id.txt_dailykal2);
        TextView ConsumedCal = (TextView)findViewById(R.id.txt_sisakalori);

        String MealTime = textViewLunch.getText().toString();
        String CurrentCal = ConsumedCal.getText().toString();
        String CalGolDiet = IntialCal.getText().toString();

        Intent i = new Intent(dietplan2Activity.this, DataListActivityFoodlist.class);


        i.putExtra("MEALTIME",MealTime);
        i.putExtra("CURRENTCAL",CurrentCal);
        i.putExtra("CALGOLDIET",CalGolDiet);
        startActivity(i);


    }

    public void DinnerClick (View v) {

        TextView IntialCal = (TextView)findViewById(R.id.txt_dailykal2);
        TextView ConsumedCal = (TextView)findViewById(R.id.txt_sisakalori);

        String MealTime = textViewDinner.getText().toString();
        String CurrentCal = ConsumedCal.getText().toString();
        String CalGolDiet = IntialCal.getText().toString();

        Intent i = new Intent(dietplan2Activity.this, DataListActivityFoodlist.class);


        i.putExtra("MEALTIME",MealTime);
        i.putExtra("CURRENTCAL",CurrentCal);
        i.putExtra("CALGOLDIET",CalGolDiet);
        startActivity(i);


    }

    public void SnackClick (View v) {

        TextView IntialCal = (TextView)findViewById(R.id.txt_dailykal2);
        TextView ConsumedCal = (TextView)findViewById(R.id.txt_sisakalori);


        String MealTime = textViewSnack.getText().toString();
        String CurrentCal = ConsumedCal.getText().toString();
        String CalGolDiet = IntialCal.getText().toString();

        Intent i = new Intent(dietplan2Activity.this, DataListActivityFoodlist.class);

        i.putExtra("MEALTIME",MealTime);
        i.putExtra("CURRENTCAL",CurrentCal);
        i.putExtra("CALGOLDIET",CalGolDiet);
        startActivity(i);


    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(dietplan2Activity.this, MainActivity.class));
        finish();

    }

}




