package com.example.rihaf.diabetesdietexpert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rihaf on 12/21/2016.
 */
public class ListDataAdaptergol extends ArrayAdapter {
   List list = new ArrayList();
    public ListDataAdaptergol(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView MEALTIME,CALORIE,CARBO,PROTEIN,VEGGIE,FRUIT,MILK;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);

    }

    @Override
    public int getCount() {
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
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layoutgol,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.MEALTIME = (TextView) row.findViewById(R.id.text_mealtime);
            layoutHandler.CALORIE = (TextView) row.findViewById(R.id.text_calorie);
            layoutHandler.CARBO = (TextView) row.findViewById(R.id.text_carb);
            layoutHandler.PROTEIN = (TextView) row.findViewById(R.id.text_protein);
            layoutHandler.VEGGIE = (TextView) row.findViewById(R.id.text_veggie);
            layoutHandler.FRUIT = (TextView) row.findViewById(R.id.text_fruit);
            layoutHandler.MILK = (TextView) row.findViewById(R.id.text_milk);

            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();


        }
        DataProvidergol dataProvidergol = (DataProvidergol) this.getItem(position);
        layoutHandler.MEALTIME.setText(dataProvidergol.getMealtime());
        layoutHandler.CALORIE.setText(dataProvidergol.getCalorie());
        layoutHandler.CARBO.setText(dataProvidergol.getCarbo());
        layoutHandler.PROTEIN.setText(dataProvidergol.getProtein());
        layoutHandler.VEGGIE.setText(dataProvidergol.getVeggie());
        layoutHandler.FRUIT.setText(dataProvidergol.getFruit());
        layoutHandler.MILK.setText(dataProvidergol.getMilk());

        return row;
    }
}
