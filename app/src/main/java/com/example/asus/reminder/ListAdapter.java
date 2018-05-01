package com.example.asus.reminder;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


/**
 * Created by asus on 30-Apr-18.
 */

public class ListAdapter extends ArrayAdapter<Reminder> {
    private final Activity context;
    private   ArrayList<Reminder>  resources;


    public ListAdapter(Activity context, ArrayList<Reminder> resource) {
        super(context,R.layout.activity_reminders,resource);

        this.context = context;
        this.resources=resource;
       // Log.e(TAG, "ListAdapter: "+resources.toString() );
    }
    public int getCount() {
        return resources.size();
    }

    @Nullable
    @Override
    public Reminder getItem(int position) {
      //  return super.getItem(position);
        return resources.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.reminders_row, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.textView);
        TextView important= (TextView) rowView.findViewById(R.id.button);

        titleText.setText("   "+resources.get(position).text);
       if(resources.get(position).imp) important.setBackgroundColor(Color.parseColor("#ffff4444"));

        return rowView;

    };

}
