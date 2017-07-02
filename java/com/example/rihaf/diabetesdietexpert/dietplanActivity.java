package com.example.rihaf.diabetesdietexpert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class dietplanActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editText,bbtxt,usiatxt  ;
    TextView imttxt,kategoritxt,idtextview;
    Button button1;
    String id, id2, text, textBB, textIMT, textKATEGORI, textUSIA, selectedtext, selectedtextB;
   //MAIN BUTTON REKOMENDASI DIET//

    //VARIABEL RADIO GROUP UNTUK SELEKSI JENIS KELAMIN//
    private static RadioGroup radio_jk;
    private static RadioButton radio_b;
    //VARIABEL RADIO GROUP UNTUK SELEKSI AKTIVITAS//
    private static RadioGroup radio_aktv;
    private static RadioButton radio_b_aktv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietplan);
        myDb = new DatabaseHelper(this);

        onClickListener(); //OnClick Function of: HITUNG IMT//


    }
//****
//****
//****
//****
//****
//****************************************AWAL---FUNGSI PADA BUTTON "HITUNG IMT"***************************************************//
public void IMTonButtonClick(View v) {
    //ASSIGN VARIABELS FOR EACH INPUT AND OUTPUT//
    EditText e1 = (EditText) findViewById(R.id.tb);
    EditText e2 = (EditText) findViewById(R.id.bb);
    TextView t1 = (TextView) findViewById(R.id.imt);
    TextView t2 = (TextView) findViewById(R.id.kategoribb);
    TextView tb_txt = (TextView) findViewById(R.id.tb_txt);
    TextView bb_txt = (TextView) findViewById(R.id.bb_txt);


//JIKA INPUT TB DAB B KOSONG MAKA AKAN MUNCUL POP-UP MESSAGE//

    if ((e1.getText().toString().length() == 0 && e2.getText().toString().length() == 0) || (e1.getText().toString().length() == 0 || e2.getText().toString().length() == 0))  {
        Toast.makeText(dietplanActivity.this, "Silahkan masukkan Tinggi Badan dan Berat Badan anda terlebih dahulu", Toast.LENGTH_LONG).show();

        t1.setText(" ");
        t2.setText(" ");
    }


    else { //JIKA INPUT TB DAB B TERISI MAKA AKAN DILAKUKAN PROSES PERHITUNGAN IMT//
        double num1 = Double.parseDouble(e1.getText().toString());
        double num2 = Double.parseDouble(e2.getText().toString());

        tb_txt.setText(Double.toString(num1));
        bb_txt.setText(Double.toString(num2));

        double sum = num2 / (num1 * num1);
        t1.setText(Double.toString(sum));

        if (sum <= 1) {
            Toast.makeText(dietplanActivity.this, "Masukkan Tinggi Badan dalam satuan meter", Toast.LENGTH_LONG).show();
            t1.setText(" ");
            t2.setText(" ");

        } else {
            if (sum < 19.8)
                t2.setText("BB Kurang");


            if (sum >= 19.8 && sum <= 26)
                t2.setText("BB Normal");

            if (sum > 26)
                t2.setText("BB Lebih");


        }

    }

}
//****************************************AKHIR --- FUNGSI PADA BUTTON "HITUNG IMT"***************************************************//


//****
//****
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
                Toast.makeText(dietplanActivity.this, "Membatalkan", Toast.LENGTH_LONG).show();
                startActivity(new Intent (dietplanActivity.this, FirstSetupActivity.class));

                return super.onOptionsItemSelected(item);

            case R.id.save_id:

                EditText editText = (EditText)findViewById(R.id.tb); //1
                EditText bbtxt = (EditText)findViewById(R.id.bb); //2
                TextView imttxt = (TextView) findViewById(R.id.imt); //3
                TextView kategoritxt = (TextView) findViewById(R.id.kategoribb); //4
                EditText usiatxt = (EditText)findViewById(R.id.usia); //5


                String text = editText.getText().toString();
                String textBB = bbtxt.getText().toString();
                String textIMT = imttxt.getText().toString();
                //  double textIMT = Double.parseDouble(imttxt.getText().toString());
                String textKATEGORI = kategoritxt.getText().toString();
                String textUSIA = usiatxt.getText().toString();

                //RADIO GROUP JENIS KELAMIN//

                RadioGroup radioGroupA = (RadioGroup) findViewById(R.id.RadioGroupJK); //6
                int radioButtonID = radioGroupA.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) radioGroupA.findViewById(radioButtonID);
                String selectedtext = (String) radioButton.getText();

                //RADIO GROUP AKTV//

                RadioGroup radioGroupB = (RadioGroup) findViewById(R.id.radioGroupAKTV); //7
                int radioButtonID2 = radioGroupB.getCheckedRadioButtonId();
                RadioButton radioButtonB = (RadioButton) radioGroupB.findViewById(radioButtonID2);
                String selectedtextB = (String) radioButtonB.getText();





                TextView discIMT = (TextView) findViewById(R.id.hideimt);
                TextView discUSIA = (TextView) findViewById(R.id.hideusia);
                TextView discJK = (TextView) findViewById(R.id.hidejk);
                TextView discAKTV = (TextView) findViewById(R.id.hideaktv);

                discIMT.setText(textIMT.toString());
                discUSIA.setText(textUSIA.toString());
                discJK.setText(selectedtext.toString());
                discAKTV.setText(selectedtextB.toString());

                String SdiscIMT = discIMT.getText().toString();
                String SdiscUSIA = discUSIA.getText().toString();
                String SdiscJK = discJK.getText().toString();
                String SdiscAKTV = discAKTV.getText().toString();



                if (SdiscIMT.length() < 4 )  {
                    Toast.makeText(dietplanActivity.this, "Hitung IMT anda terlebih dahulu", Toast.LENGTH_LONG).show();

                }
                else
                if (SdiscUSIA.equals("") || SdiscJK.equals("0") || SdiscAKTV.equals("0"))  {
                    Toast.makeText(dietplanActivity.this, "Data anda belum lengkap. Lengkapi data anda terlebih dahulu", Toast.LENGTH_LONG).show();

                }


                else {

                    //---------------------AWAL : INSERT DATA INPUT TO DATABASE SQLite--------------------------------------------//
                    boolean isInserted =  myDb.insertData(text,textBB,textIMT,textKATEGORI,textUSIA,selectedtext,selectedtextB);
                    if(isInserted =true)
                        Toast.makeText(dietplanActivity.this,"DATA TELAH DISIMPAN", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(dietplanActivity.this,"DATA GAGAL DISIMPAN", Toast.LENGTH_LONG).show();
                    //---------------------AKHIR : INSERT DATA INPUT TO DATABASE SQLite--------------------------------------------//

                    startActivity(new Intent(dietplanActivity.this, DataListActivity.class));

                }





            default:
                return super.onOptionsItemSelected(item);
        }
    }

//****
//****
//****
//****
//****
//****
//*****************************************AWAL DARI ONCLICKLISTENER RADIO BUTTON***********************************************//
public void onClickListener(){
//*************************************RADIO BUTTON UNTUK MEMILIH JENIS KELAMIN*************************************************//
radio_jk=(RadioGroup)findViewById(R.id.RadioGroupJK);



    radio_jk.setOnClickListener(
            new View.OnClickListener()
            {
                @Override
                public void onClick (View v){
                    int selected_id=radio_jk.getCheckedRadioButtonId();
                    radio_b=(RadioButton)findViewById(selected_id);


                }
            });


//*****************************************RADIO BUTTON UNTUK MEMILIH AKTIVITAS***********************************************//



        radio_aktv=(RadioGroup)findViewById(R.id.radioGroupAKTV);



        radio_aktv.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick (View v){
                        int selected_id=radio_aktv.getCheckedRadioButtonId();
                        radio_b_aktv=(RadioButton)findViewById(selected_id);


                    }
                });
    }
//*****************************************AKHIR DARI ONCLICKLISTENER RADIO BUTTON***********************************************//


}






