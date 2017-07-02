package com.example.rihaf.diabetesdietexpert;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class HistoryActivity extends AppCompatActivity {
    Button btn;
    int year_x,month_x,day_x;
    static final int DIALOG_ID = 0;


    ListView list_view_journal;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper userDbHelper;
    Cursor cursor;

    ListDataAdapterJournal listDataAdapterJournal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        list_view_journal = (ListView) findViewById(R.id.list_view_journal);
        userDbHelper = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();




//---------------------- BELOW IS CALENDAR COMPONENTS -------------------------------//

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnButtonClick();

}

//---------------------- END LISTVIEW COMPONENTS -------------------------------//

    public void showDialogOnButtonClick() {
        btn = (Button)findViewById(R.id.buttondate);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListener, year_x,month_x,day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear + 1;
            day_x = dayOfMonth;





            TextView visibleDate = (TextView) findViewById(R.id.visibledate);
            TextView InvisibleDate = (TextView) findViewById(R.id.invisibledate);

            visibleDate.setText(day_x +  " / " + month_x +  " / " + year_x);
            assert InvisibleDate != null;
            InvisibleDate.setText(month_x+""+day_x+""+year_x);

            //---------------------- BELOW IS DATABASE LISTVIEW COMPONENTS -------------------------------//

            TextView Date1 = (TextView)findViewById(R.id.invisibledate);
            String DateHistory1 = Date1.getText().toString();
            cursor = userDbHelper.getJournalDietHistory(DateHistory1);
            listDataAdapterJournal = new ListDataAdapterJournal(getApplicationContext(), R.layout.row_layout_journal);
            list_view_journal.setAdapter(listDataAdapterJournal);



            if (cursor.moveToFirst()) {
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
                } while (cursor.moveToNext());
            }


//------------------------BELOW COUNTING THE TOTAL CALORIC CONSUMPTION FOR THE DAY ----------------------------//


         //   TextView DateShow = (TextView)findViewById(R.id.invisibledate);
            String tanggals = Date1.getText().toString();
            //int tanggals = Integer.parseInt(DateShow.getText().toString());

            //    double num1 = Double.parseDouble(e1.getText().toString());
            Integer CountKal = userDbHelper.getRemainingCalorie(tanggals);

            TextView sisakalori = (TextView) findViewById(R.id.totalkalorihistory);
            sisakalori.setText(CountKal.toString()+" Kalori");


        }
    };



}
