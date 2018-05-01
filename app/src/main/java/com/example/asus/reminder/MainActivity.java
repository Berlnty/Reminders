package com.example.asus.reminder;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList<Reminder> reminders;
    ListAdapter adapter;
    int edited_item_position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        reminders = new ArrayList<Reminder>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        list = (ListView) findViewById(R.id.listview);
        reminders.add(new Reminder("Reminder 1",false));
        reminders.add(new Reminder("reminder2",true));
        reminders.add(new Reminder("reminder3",false));
        reminders.add(new Reminder("reminder4",false));


       adapter = new ListAdapter(this, reminders);
        list.setAdapter(adapter);
        registerForContextMenu(list);


    }
        @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuinfo){

            super.onCreateContextMenu(menu,v,menuinfo);

            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.context_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){

            case R.id.delete:
               reminders.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.edit:
                edit_item(info.position);
            default:return super.onContextItemSelected(item);

        }


    }

    public void edit_item(int position){


        Intent intent  = new Intent(getApplicationContext(), Dialog.class);

        intent.putExtra("title","Edit");
        Reminder temp= reminders.get(position);
        intent.putExtra("Reminder",  temp);
        edited_item_position=position;
        startActivityForResult(intent,0);


    }

     public void Add_item(){


        Intent intent  = new Intent(getApplicationContext(), Dialog.class);

        intent.putExtra("title","Add");
        Reminder temp= new Reminder("",false);
        intent.putExtra("Reminder",  temp);
        startActivityForResult(intent,1);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                reminders.set (edited_item_position,(Reminder) data.getSerializableExtra("Reminder"));
              adapter.notifyDataSetChanged();
            }
        }
        else if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                reminders.add((Reminder) data.getSerializableExtra("Reminder"));
                adapter.notifyDataSetChanged();
            }
        }
    }

 @Override
    public boolean onCreateOptionsMenu(Menu menu){

      getMenuInflater().inflate(R.menu.option_menu,menu);
     return true;


 }

 public boolean onOptionsItemSelected(MenuItem item){

     switch(item.getItemId()){
         case R.id.Add:
             Add_item();
             break;
         case R.id.exit:  moveTaskToBack(true);
             android.os.Process.killProcess(android.os.Process.myPid());
             System.exit(1);

     }

     return super.onOptionsItemSelected(item);
 }

}
