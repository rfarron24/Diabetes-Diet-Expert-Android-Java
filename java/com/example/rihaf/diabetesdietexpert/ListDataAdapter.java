package com.example.rihaf.diabetesdietexpert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by rihaf on 12/15/2016.
 */
public class ListDataAdapter extends ArrayAdapter { //ARRAY ADAPTER UNTUK MEMUNCULKAN URUTAN DATA PADA DATABASE//
    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler //CLASS STATIK UNTUK MEMBUAT LAYOUT BARU PADA SAAT DATA DIPANGGIL DARI DATABASE//
    {
        TextView TB,BB,IMT,KATEGORI,UMUR,JK,AKTIVITAS; //DEKLARASI KONSTANTA UNTUK KOLOM TABEL//
    }

    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int position){
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);

            layoutHandler = new LayoutHandler(); //MENGIDENTIFIKASI IDENTITAS TIAP2 TEXTVIEW PADA data_list_layout.XML//
            layoutHandler.TB = (TextView) row.findViewById(R.id.text_tb);
            layoutHandler.BB = (TextView) row.findViewById(R.id.text_bb);
            layoutHandler.IMT = (TextView) row.findViewById(R.id.text_imt);
            layoutHandler.KATEGORI = (TextView) row.findViewById(R.id.text_kategori);
            layoutHandler.UMUR = (TextView) row.findViewById(R.id.text_umur);
            layoutHandler.JK = (TextView) row.findViewById(R.id.text_jk);
            layoutHandler.AKTIVITAS = (TextView) row.findViewById(R.id.text_aktv);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }
        DataProvider dataProvider = (DataProvider) this.getItem(position);

        //MELETAKKAN TIAP2 DATA ANTROPOMETRI PADA TEXTVIEW data_list_layout.XML
        layoutHandler.TB.setText(dataProvider.getTb().toString());
        layoutHandler.BB.setText(dataProvider.getBb().toString());
        layoutHandler.IMT.setText(dataProvider.getImt().toString());
        layoutHandler.KATEGORI.setText(dataProvider.getKategori());
        layoutHandler.UMUR.setText(dataProvider.getUmur().toString());
        layoutHandler.JK.setText(dataProvider.getJk());
        layoutHandler.AKTIVITAS.setText(dataProvider.getAktivitas());


        return row;


    }
}
