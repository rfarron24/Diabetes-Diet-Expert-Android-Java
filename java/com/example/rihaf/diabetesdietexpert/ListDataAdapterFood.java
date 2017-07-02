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
 * Created by rihaf on 12/26/2016.
 */
public class ListDataAdapterFood extends ArrayAdapter {
    List list = new ArrayList();

    public ListDataAdapterFood(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView NAMA,PORSI,KALPORSI,KALGRAM,PROTEIN,LEMAK,KARBOHIDRAT; //DEKLARASI KONSTANTA UNTUK
    }
    @Override
    public void add (Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
   public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout_food, parent, false);

            layoutHandler = new LayoutHandler(); //MENGIDENTIFIKASI IDENTITAS TIAP2 TEXTVIEW PADA data_list_layout.XML//
            layoutHandler.NAMA = (TextView) row.findViewById(R.id.txt_food2);
            layoutHandler.PORSI = (TextView) row.findViewById(R.id.txt_portion2);
            layoutHandler.KALPORSI = (TextView) row.findViewById(R.id.txt_cal2);
            layoutHandler.KALGRAM = (TextView) row.findViewById(R.id.txt_kalgram);
            layoutHandler.PROTEIN = (TextView) row.findViewById(R.id.txt_protein2);
            layoutHandler.LEMAK = (TextView) row.findViewById(R.id.txt_fat2);
            layoutHandler.KARBOHIDRAT = (TextView) row.findViewById(R.id.txt_carb2);
            row.setTag(layoutHandler);

        }

        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }
        DataProviderFoodlist dataProviderFoodlist = (DataProviderFoodlist) this.getItem(position);

        //MELETAKKAN TIAP2 DATA ANTROPOMETRI PADA TEXTVIEW data_list_layout.XML
        layoutHandler.NAMA.setText(dataProviderFoodlist.getName());
        layoutHandler.PORSI.setText(dataProviderFoodlist.getPorsi());
        layoutHandler.KALPORSI.setText(dataProviderFoodlist.getPorsikal().toString());
        layoutHandler.KALGRAM.setText(dataProviderFoodlist.getGramkal().toString());
        layoutHandler.PROTEIN.setText(dataProviderFoodlist.getProteincontent());
        layoutHandler.LEMAK.setText(dataProviderFoodlist.getFatcontent());
        layoutHandler.KARBOHIDRAT.setText(dataProviderFoodlist.getCarbcontent());


        return row;
    }
}
