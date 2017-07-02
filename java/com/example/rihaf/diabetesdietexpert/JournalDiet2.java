package com.example.rihaf.diabetesdietexpert;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;


public class JournalDiet2 extends AppCompatActivity {
    ListView listView = null;
    String passedVar = null;
    DatabaseHelper myDb;
    TextView foodname2, portion, calorie, calendar, mealtime, calorietotal, kalender, currentcalorie2,calgoldietjournal;
    private TextView passedView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_diet2);
        myDb = new DatabaseHelper(this);

        listView = new ListView(this);
        String[] items = {"Sarapan", "Makan Siang", "Makan Malam", "Snack"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem,items);
        listView.setAdapter(adapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(JournalDiet2.this);
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", null);
        builder.setView(listView);
        AlertDialog dialog = builder.create();
        dialog.show();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ViewGroup vg = (ViewGroup) view;
                TextView txt = (TextView) vg.findViewById(R.id.txtitem);

                String WaktuMakan = txt.getText().toString();

                Toast.makeText(JournalDiet2.this,WaktuMakan, Toast.LENGTH_LONG).show();

                TextView mealTime = (TextView) findViewById(R.id.txt_waktumakan);
                mealTime.setText(WaktuMakan.toString());
            }
        });

        mealtime = (TextView) findViewById(R.id.txt_waktumakan);
        foodname2 = (TextView) findViewById(R.id.txt_foodname2);
        portion = (TextView) findViewById(R.id.txt_portion);
        calorie = (TextView) findViewById(R.id.txt_calorie);

        currentcalorie2 = (TextView) findViewById(R.id.currentcal2);

        currentcalorie2.setText(getIntent().getStringExtra("CURRENTCAL"));

        calgoldietjournal = (TextView) findViewById(R.id.calgoldiet2);

        calgoldietjournal.setText(getIntent().getStringExtra("CALGOLDIET"));

        mealtime.setText(getIntent().getStringExtra("MLTM"));
//------------------------------------BELOW : ADD AUTOMATIC CURRENT DATE----------------------------------//
        calendar = (TextView) findViewById(R.id.calendartxt);


        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("Mdyyyy");
        String dateString = sdf.format(date);
        calendar.setText(dateString);

        kalender = (TextView) findViewById(R.id.calendartxt);


        //---------------------BELOW : ROW FOOD ITEM ID INTENT SENT FROM dietplan2ACTIVITY ----------------//
        passedVar = getIntent().getStringExtra(dietplan2Activity.ID_EXTRA);
        passedView = (TextView) findViewById(R.id.idzz);
        passedView.setText(passedVar);

        TextView id1 = (TextView) findViewById(R.id.idzz);
        TextView id3 = (TextView) findViewById(R.id.id3);

        int id_value = Integer.parseInt(id1.getText().toString());
        int sum = id_value + 1;
        id3.setText(Integer.toString(sum));


//---------------------BELOW : TO FETCH FOOD NAME FROM TABLE_FOODLIST BASED ON FOODLIST ID ----------------//
        TextView editTextId = (TextView) findViewById(R.id.id3);
        String idTXT = editTextId.getText().toString();


        String FoodName = myDb.getNameJournalDiet(idTXT);

        TextView txtfoodname = (TextView) findViewById(R.id.txt_foodname2);
        txtfoodname.setText(FoodName.toString());


//---------------------BELOW : TO FETCH FOOD PORTION FROM TABLE_FOODLIST BASED ON FOODLIST ID ----------------//


        String FoodPortion = myDb.getPortionJournalDiet(idTXT);

        TextView txtportion = (TextView) findViewById(R.id.txt_portion);
        txtportion.setText(FoodPortion.toString());


//---------------------BELOW : TO FETCH FOOD CALORIE FROM TABLE_FOODLIST BASED ON FOODLIST ID ----------------//


        String Foodcal = myDb.getCalJournalDiet(idTXT);

        TextView txtcal = (TextView) findViewById(R.id.txt_calorie);
        TextView txtcaltotaljurnal = (TextView) findViewById(R.id.txt_kaloritotaljurnal);
        txtcal.setText(Foodcal.toString());
        txtcaltotaljurnal.setText(Foodcal.toString());

    }


    public void ButtonHitungTotalKalori (View v) {

        //-------------BELOW:  SUM TOTAL CALORIE-----------------------------//
        portion = (TextView)findViewById(R.id.txt_portion);
        calorie = (TextView)findViewById(R.id.txt_calorie);
        calorietotal = (TextView)findViewById(R.id.txt_kaloritotaljurnal);
        EditText quantity = (EditText) findViewById(R.id.qty);

        //    String calorietotalstrg = calorietotal.getText().toString();

        double num1 = Double.parseDouble(calorie.getText().toString());
        double num2 = Double.parseDouble(quantity.getText().toString());

        double totalcalor = num1 * num2;

        calorietotal.setText(Double.toString(totalcalor));
    }


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Toast.makeText(JournalDiet2.this, "Jurnal Diet Dibatalkan", Toast.LENGTH_LONG).show();
        startActivity(new Intent(JournalDiet2.this, dietplan2Activity.class));
        finish();

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
                Toast.makeText(JournalDiet2.this, "Jurnal Diet Dibatalkan", Toast.LENGTH_LONG).show();
                startActivity(new Intent (JournalDiet2.this, dietplan2Activity.class));

                return super.onOptionsItemSelected(item);

            case R.id.save_id:
                TextView  totalkalori = (TextView)findViewById(R.id.txt_kaloritotaljurnal);
                EditText Qty = (EditText) findViewById(R.id.qty);
                TextView  currentkalori = (TextView)findViewById(R.id.currentcal2);
                TextView  kebutuhankaloriharian = (TextView)findViewById(R.id.calgoldiet2);

                double DailyCalValue = Double.parseDouble(kebutuhankaloriharian.getText().toString());
                double currentCalValue = Double.parseDouble(currentkalori.getText().toString());
                double inputcalorie = Double.parseDouble(totalkalori.getText().toString());
                double sum = currentCalValue + inputcalorie;



                if (sum > DailyCalValue )  {
                    startActivity(new Intent(JournalDiet2.this, WarningPage.class));    }

                else

                if (totalkalori.getText().toString().length() == 0) {
                    Toast.makeText(JournalDiet2.this, "Silahkan Hitung Total Kalori Anda Terlebih Dahulu", Toast.LENGTH_LONG).show();
                }

                else {
                    //------------------WRITE INSERT DIET_JOURNAL METHOD AND DATABASE SELECTION BELOW---------//
                    String mealtimeS = mealtime.getText().toString();
                    String foodnameS = foodname2.getText().toString();
                    String portionS = portion.getText().toString();
                    String calorieS = calorie.getText().toString();
                    String dateS = kalender.getText().toString();
                    String qtyS = Qty.getText().toString();
                    String TotalS = totalkalori.getText().toString();

                    //---------------------AWAL : INSERT DATA INPUT TO DATABASE SQLite--------------------------------------------//
                    boolean isInserted =  myDb.insertDataMealTime(dateS,mealtimeS,foodnameS,portionS,calorieS,qtyS,TotalS);
                    if(isInserted =true)
                        Toast.makeText(JournalDiet2.this,"DATA TELAH DISIMPAN", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(JournalDiet2.this,"DATA GAGAL DISIMPAN", Toast.LENGTH_LONG).show();
                    //---------------------AKHIR : INSERT DATA INPUT TO DATABASE SQLite--------------------------------------------//


                    startActivity(new Intent(JournalDiet2.this, dietplan2Activity.class));

                }

            default:
                return super.onOptionsItemSelected(item);

        }


    }




}
