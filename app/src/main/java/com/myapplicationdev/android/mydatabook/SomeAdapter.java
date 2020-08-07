package com.myapplicationdev.android.mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SomeAdapter extends ArrayAdapter<String> {

    private ArrayList<String> stuff;
    private Context context;
    private TextView tv1;
    private ImageView iv1;


    public SomeAdapter(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        stuff = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tv1 = (TextView) rowView.findViewById(R.id.textView2);
        iv1 = (ImageView) rowView.findViewById(R.id.imageView2);
        // Get the ImageView object

        String currentThing = stuff.get(position);
        if (position == 0) {
            iv1.setImageResource(android.R.drawable.ic_menu_info_details);
        } else if (position == 1) {
            iv1.setImageResource(android.R.drawable.ic_menu_edit);
        } else if (position == 2) {
            iv1.setImageResource(android.R.drawable.ic_menu_my_calendar);
        } else if (position == 3) {
            iv1.setImageResource(android.R.drawable.star_on);
        }
        tv1.setText(currentThing);


        // Return the nicely done up View to the ListView
        return rowView;
    }
}