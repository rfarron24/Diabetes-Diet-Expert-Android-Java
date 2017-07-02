package com.example.rihaf.diabetesdietexpert;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DbControl extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editText,bbtxt,usiatxt, editTextId  ;
    TextView imttxt,kategoritxt,idtextview;
    Button button1;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;
    Button BTemp1;
    Button BTemp2;
    String id, id2, text, textBB, textIMT, textKATEGORI, textUSIA, selectedtext, selectedtextB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbcontrol);
;
         myDb = new DatabaseHelper(this);

        BTemp1 = (Button) findViewById(R.id.temp1);
        BTemp2 = (Button) findViewById(R.id.temp2);

        btnviewAll = (Button)findViewById(R.id.button_update);
        btnDelete = (Button)findViewById(R.id.button_delete);
        viewAll();
        DeleteData ();


        BTemp1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent (DbControl.this, TemporaryActivity.class));
            }
        });

        BTemp2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent (DbControl.this, TemporaryActivity2.class));
            }
        });
    }
//********//
//********//
//********//
    //****************************************START---FUNGSI TOMBOL DELETE DATA"*********************************************************//

    public void DeleteData (){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        editTextId = (EditText)findViewById(R.id.id_txt);




                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(DbControl.this,"DATA TELAH DIHAPUS", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(DbControl.this,"TAK ADA DATA DIHAPUS", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
//****************************************END---FUNGSI TOMBOL DELETE DATA"*********************************************************//
//********//
//********//
//********//
//****************************************START---FUNGSI TOMBOL LIHAT DATA MENGGUNAKAN ListView"*********************************************************//

    public void ViewData(View view) //"ViewData" is the OnClick button for "LIHAT DATA SAYA"//
    {
        Intent intent = new Intent(this, DataListActivity.class); //Intent is used when an output wants to be showed on another activity//
        startActivity(intent); //when the button clicked the Activity will be started//
    }
//****************************************END---FUNGSI TOMBOL LIHAT DATA MENGGUNAKAN ListView"********************************************************//********//
//********//
//********//
//****************************************START---FUNGSI TOMBOL LIHAT SEMUA DATA MELALUI POP-UP"*********************************************************//
    public void viewAll(){
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    //WHEN THIS BUTTON IS CLICKED, WE WANTED TO PERFORM SOME ACTION//
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount()==0) { //MEANS THAT IF THERE'S NO DATA AVAILABLE//
                            //SHOW MESSAGE
                            showMessage("Error", "No Data Found");
                            return;

                        }
                        //IF THERE'S RESULT, DO:
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Tb :"+ res.getString(1)+"\n");
                            buffer.append("Bb :"+ res.getString(2)+"\n");
                            buffer.append("Imt :"+ res.getString(3)+"\n");
                            buffer.append("Kategori :"+ res.getString(4)+"\n");
                            buffer.append("Usia :"+ res.getString(5)+"\n");
                            buffer.append("Jk :"+ res.getString(6)+"\n");
                            buffer.append("Aktivitas :"+ res.getString(7)+"\n\n");
                        }
                        //SHOW ALL DATA
                        showMessage("Data",buffer.toString());

                    }
                }
        );
    }

    //BELOW IS THE METHOD TO CREATE POP-UP DIALOG MESSAGE TO SHOW TABLE VALUES//

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


//****************************************END---FUNGSI TOMBOL LIHAT SEMUA DATA MELALUI POP-UP"*********************************************************//


}
