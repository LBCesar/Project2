/*
    From the class: Lab6 - BaseAdapter

    For creating a gridView
 */

package com.example.project2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflter;
    private int animals[];
//    {R.drawable.animal13, R.drawable.animal14, R.drawable.animal15,
//            R.drawable.animal16, R.drawable.animal17, R.drawable.animal18,
//            R.drawable.animal15, R.drawable.animal16, R.drawable.animal17};


    public CustomAdapter (Context applicationContext, int[] animals){
        this.context = applicationContext;
        this.animals = animals;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {     // get total number of items
        return animals.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_gridview, null);
        ImageView icon = view.findViewById(R.id.icon);
        icon.setImageResource(animals[position]);
        return view;
    }

}// end class
