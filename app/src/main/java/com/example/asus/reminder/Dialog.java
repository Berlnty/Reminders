package com.example.asus.reminder;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Dialog extends AppCompatActivity {
    Reminder temp;
    EditText rem;
    CheckBox imp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);

        Intent intent = getIntent();
         intent.getStringExtra("detail");
      temp= (Reminder) getIntent().getSerializableExtra("Reminder");

        TextView title=(TextView) findViewById(R.id.textView4);
        rem=(EditText) findViewById(R.id.editText2);
       imp=(CheckBox) findViewById(R.id.checkBox2);
        Button cancel=(Button) findViewById(R.id.button4);
        Button commit=(Button) findViewById(R.id.button5);

        title.setText(   intent.getStringExtra("title"));
        rem.setText(  temp.getText());
        imp.setChecked(temp.getimp());


cancel.setOnClickListener(new View.OnClickListener(){


           @Override
           public void onClick(View v) {
                finish();
           }

         });
commit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        temp.set_text(rem.getText().toString().trim());
        temp.setimp(imp.isChecked());
        Intent data = new Intent();
        data.putExtra("Reminder",  temp);
        setResult(RESULT_OK, data);
        finish();
    }
});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }


}
