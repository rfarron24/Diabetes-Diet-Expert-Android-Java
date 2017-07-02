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

public class DataListActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    TextView TB, BB, IMT, KATEGORI, UMUR, JK, AKTIVITAS;
    ListView listView;
    Button button1;
    Double kalori;
    Double bobotusia;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper userDBHelper; //userDBHelper ADALAH NAMA VARIABLE BARU DARI DatabaseHelper KHUSUS UNTUK MEMANGGIL DATA DARI DATABASE//
    Cursor cursor; //UNTUK MENJUNJUKKAN POSISI ROW TERBARU DARI DATABASE//
    ListDataAdapter listDataAdapter; //VARIABLE UNTUK MENGIMPLEMENTASIKAN METODE DARI CLASS ListDataAdapter.JAVA//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
        myDb = new DatabaseHelper(this);

        listView = (ListView) findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        userDBHelper = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = userDBHelper.getReadableDatabase();
        cursor = userDBHelper.getInformation(sqLiteDatabase);



        if (cursor.moveToFirst()) {
            do {

                Double tb, bb, imt;
                Integer umur;
                String kategori, jk, aktivitas;

                tb = cursor.getDouble(0);
                bb = cursor.getDouble(1);
                imt = cursor.getDouble(2);
                kategori = cursor.getString(3);
                umur = cursor.getInt(4);
                jk = cursor.getString(5);
                aktivitas = cursor.getString(6);

                //MEMANGGIL DARI CLASS DataProvider.Java//
                DataProvider dataProvider = new DataProvider(tb, bb, imt, kategori, umur, jk, aktivitas);
                listDataAdapter.add(dataProvider);

            } while (cursor.moveToNext());


        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info_id:
                TextView idv = (TextView) findViewById(R.id.txt_idview);
                //  TextView tbtxt = (TextView) findViewById(R.id.text_tb);
                TextView bbtxt = (TextView) findViewById(R.id.text_bb);
                //  TextView imttxt = (TextView) findViewById(R.id.text_imt);
                TextView kategoritxt = (TextView) findViewById(R.id.text_kategori);
                TextView usiatxt = (TextView) findViewById(R.id.text_umur);
                TextView jktxt = (TextView) findViewById(R.id.text_jk);
                TextView aktivitastxt = (TextView) findViewById(R.id.text_aktv);

                TextView txt_ka = (TextView) findViewById(R.id.txt_ka);
                TextView txt_bu = (TextView) findViewById(R.id.txt_bobotusia);
                TextView txt_bak = (TextView) findViewById(R.id.txt_bobotaktvty);
                TextView txt_bktg = (TextView) findViewById(R.id.txt_bobotkateg);
                TextView txt_kal = (TextView) findViewById(R.id.txt_cal);

                double bb = Double.parseDouble(bbtxt.getText().toString());
                String kategori = kategoritxt.getText().toString();
                double usia = Double.parseDouble(usiatxt.getText().toString());
                String jk = jktxt.getText().toString();
                String aktifitas = aktivitastxt.getText().toString();


                //------KALORI AWAL---------//
                if (jk.equals("Pria"))

                    txt_ka.setText(Double.toString(bb*30));

                if (jk.equals("Wanita"))

                    txt_ka.setText(Double.toString(bb*25));

                //----------BOBOT USIA--------//

                if (usia < 41)

                    txt_bu.setText(Double.toString(0));

                if (usia >= 41 && usia <= 59)

                    txt_bu.setText(Double.toString(0.05));


                if (usia >= 60 && usia <= 69)

                    txt_bu.setText(Double.toString(0.1));

                if (usia >= 70)

                    txt_bu.setText(Double.toString(0.2));

                //----------BOBOT AKTIVITAS--------//

                if (aktifitas.equals("Istirahat"))

                    txt_bak.setText(Double.toString(0.1));

                if (aktifitas.equals("Ringan"))

                    txt_bak.setText(Double.toString(0.2));

                if (aktifitas.equals("Sedang"))

                    txt_bak.setText(Double.toString(0.3));

                if (aktifitas.equals("Berat"))

                    txt_bak.setText(Double.toString(0.5));

                //----------BOBOT KATEGORI BB--------//

                if (kategori.equals("BB Kurang") && jk.equals("Pria"))

                    txt_bktg.setText(Double.toString(+((bb * 30) * 0.2)));

                if (kategori.equals("BB Kurang") && jk.equals("Wanita"))

                    txt_bktg.setText(Double.toString(+((bb * 25) * 0.2)));

                if (kategori.equals("BB Normal"))

                    txt_bktg.setText(Double.toString(0));

                if (kategori.equals("BB Lebih") && jk.equals("Pria"))

                    txt_bktg.setText(Double.toString(-((bb * 30) * 0.2)));

                if (kategori.equals("BB Lebih") && jk.equals("Wanita"))

                    txt_bktg.setText(Double.toString(-((bb * 25) * 0.2)));

                double bbt1 = Double.parseDouble(txt_ka.getText().toString());
                double bbt2 = Double.parseDouble(txt_bu.getText().toString());
                double bbt3 = Double.parseDouble(txt_bak.getText().toString());
                double bbt4 = Double.parseDouble(txt_bktg.getText().toString());
                double kalori = bbt1 - bbt2 + bbt3 + bbt4 ;
                txt_kal.setText(Double.toString(kalori));

                // double finalkalori = Double.parseDouble(txt_kal.getText().toString());

                String finalkalori = txt_kal.getText().toString();
                String id16 = idv.getText().toString();



                Cursor res = myDb.getDailyCalorieData();

                if(res.getCount()==0){
                    boolean isInserted =  myDb.insertDataDailyCalorie(finalkalori);
                    if(isInserted =true)
                        Toast.makeText(DataListActivity.this,"DATA TELAH DITAMBAH", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(DataListActivity.this,"DATA GAGAL DITAMBAH", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(DataListActivity.this, DataListActivityGol.class));}

                else{
                    boolean isUpdate =  myDb.updateDataDailyCalorie(id16, finalkalori);
                    if(isUpdate =true)
                        Toast.makeText(DataListActivity.this,"MENAMPILKAN SUSUNAN DIET", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(DataListActivity.this,"SYSTEM ERROR", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(DataListActivity.this, DataListActivityGol.class));}



                return super.onOptionsItemSelected(item);

case R.id.edit_id:
startActivity(new Intent(DataListActivity.this, dietplanActivityedit.class));
default:
return super.onOptionsItemSelected(item);
 }
 }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(DataListActivity.this, MainActivity.class));
        finish();

    }
 }


















