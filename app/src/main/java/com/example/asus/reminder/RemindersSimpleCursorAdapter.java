package com.example.asus.reminder;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by engMa_000 on 2017-04-03.
 */

public class RemindersSimpleCursorAdapter extends SimpleCursorAdapter {

    public RemindersSimpleCursorAdapter(Context context, int layout, Cursor c, String[]  from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }
    //to use a viewholder, you must override the following two methods and define a ViewHolder class
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
      //  return super.newView(context, cursor, parent);
        return LayoutInflater.from(context).inflate(R.layout.reminders_row, parent, false);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder();
            holder.colImp = cursor.getColumnIndexOrThrow(RemindersDbAdapter.COL_IMPORTANT);
            holder.colContent=cursor.getColumnIndexOrThrow(RemindersDbAdapter.COL_CONTENT);

            holder.titleText =(TextView)  view.findViewById(R.id.textView3);
            holder. important= (TextView) view.findViewById(R.id.button);
            view.setTag(holder);
        }

       holder. titleText.setText(cursor.getString(holder.colContent));

        if (cursor.getInt(holder.colImp) > 0) {
            holder.important.setBackgroundColor(Color.parseColor("#ffff4444"));
        }
    }
    static class ViewHolder {
        //store the column index
        int colImp;
        int colContent;
        //store the view

        TextView titleText ;
        TextView important;

    }

}
