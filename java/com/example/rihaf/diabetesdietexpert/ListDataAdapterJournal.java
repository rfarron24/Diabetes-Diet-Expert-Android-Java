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
 * Created by rihaf on 12/29/2016.
 */
public class ListDataAdapterJournal extends ArrayAdapter {
    List list = new ArrayList();

    public ListDataAdapterJournal(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView WAKTUMAKAN,JENISMAKAN,PORSIMAKAN,KALORIMAKAN,QTY,TOTAL; //DEKLARASI KONSTANTA UNTUK
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
            row = layoutInflater.inflate(R.layout.row_layout_journal, parent, false);

            layoutHandler = new LayoutHandler();
            layoutHandler.WAKTUMAKAN = (TextView) row.findViewById(R.id.txt_waktumakan);
            layoutHandler.JENISMAKAN = (TextView) row.findViewById(R.id.txt_jenismakanan);
            layoutHandler.PORSIMAKAN = (TextView) row.findViewById(R.id.txt_porsimakanan);
            layoutHandler.KALORIMAKAN = (TextView) row.findViewById(R.id.txt_kalorimakanan);

            layoutHandler.QTY = (TextView) row.findViewById(R.id.txt_qty);
            layoutHandler.TOTAL = (TextView) row.findViewById(R.id.txt_total);

            row.setTag(layoutHandler);

        }

        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }
        dataProviderJournal dataProviderJournals = (dataProviderJournal) this.getItem(position);


        layoutHandler.WAKTUMAKAN.setText(dataProviderJournals.getWaktumakan());
        layoutHandler.JENISMAKAN.setText(dataProviderJournals.getJenismakan());
        layoutHandler.PORSIMAKAN.setText(dataProviderJournals.getPorsimakan());
        layoutHandler.KALORIMAKAN.setText(dataProviderJournals.getKalorimakan().toString());

        layoutHandler.QTY.setText(dataProviderJournals.getQty());
        layoutHandler.TOTAL.setText(dataProviderJournals.getTotal().toString());



        return row;
    }
}
