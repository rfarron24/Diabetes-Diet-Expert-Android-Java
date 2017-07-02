package com.example.rihaf.diabetesdietexpert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class dietplanActivityedit extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editText,bbtxt,usiatxt ;
    TextView imttxt,kategoritxt,idtextview;
    Button btnviewUpdate;

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
        setContentView(R.layout.activity_dietplanedit);
        myDb = new DatabaseHelper(this);

        btnviewUpdate = (Button)findViewById(R.id.button_update);


        onClickListener(); //OnClick Function of: HITUNG IMT//
        UpdateData();


        String txtiduser = myDb.getIdUser();
        TextView txtiduserstng = (TextView) findViewById(R.id.id_textview);

        txtiduserstng.setText(txtiduser.toString());


    }
//****
//****
//****
//****
//****
//****
//****
//****************************************START---FUNGSI TOMBOL UPDATE DATA"*********************************************************//
public void UpdateData(){
    btnviewUpdate.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idtextview = (TextView)findViewById(R.id.id_textview);
                    editText = (EditText)findViewById(R.id.tb); //1
                    bbtxt = (EditText)findViewById(R.id.bb); //2
                    imttxt = (TextView) findViewById(R.id.imt); //3
                    kategoritxt = (TextView) findViewById(R.id.kategoribb); //4
                    usiatxt = (EditText)findViewById(R.id.usia); //5

                    String id2 = idtextview.getText().toString();
                    String text = editText.getText().toString();
                    String textBB = bbtxt.getText().toString();
                    String textIMT = imttxt.getText().toString();
                    String textKATEGORI = kategoritxt.getText().toString();
                    String textUSIA = usiatxt.getText().toString();

                    RadioGroup radioGroupA = (RadioGroup) findViewById(R.id.RadioGroupJK); //6
                    int radioButtonID = radioGroupA.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) radioGroupA.findViewById(radioButtonID);
                    String selectedtext = (String) radioButton.getText();

                    //RADIO GROUP AKTV//
                    RadioGroup radioGroupB = (RadioGroup) findViewById(R.id.radioGroupAKTV); //7
                    int radioButtonID2 = radioGroupB.getCheckedRadioButtonId();
                    RadioButton radioButtonB = (RadioButton) radioGroupB.findViewById(radioButtonID2);
                    String selectedtextB = (String) radioButtonB.getText();

//-------------- BELOW TO SHOW CURRENT USER ID CONTENT TO TEXTVIEW ---------------------//

                    boolean isUpdate = myDb.updateData(id2, text,textBB,textIMT,textKATEGORI,textUSIA,selectedtext,selectedtextB);
                    if(isUpdate == true)
                        Toast.makeText(dietplanActivityedit.this,"DATA TELAH DIUBAH", Toast.LENGTH_LONG).show();
                        else
                        Toast.makeText(dietplanActivityedit.this,"DATA GAGAL DIUBAH", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(dietplanActivityedit.this, DataListActivity.class));
                }

                }
    );
}
 //****************************************END---FUNGSI TOMBOL UPDATE DATA"*********************************************************//
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
            Toast.makeText(dietplanActivityedit.this, "Silahkan masukkan Tinggi Badan dan Berat Badan anda terlebih dahulu", Toast.LENGTH_LONG).show();

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
                Toast.makeText(dietplanActivityedit.this, "Masukkan Tinggi Badan dalam satuan meter", Toast.LENGTH_LONG).show();
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


    public void cancelbutton(View v) {

        startActivity(new Intent(dietplanActivityedit.this, DataListActivity.class));
    }
//****************************************AKHIR --- FUNGSI PADA BUTTON "HITUNG IMT"***************************************************//
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






