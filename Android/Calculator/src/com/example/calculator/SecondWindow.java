package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class SecondWindow extends Activity {
	public static final String THETEXT = "asdf"; //used as key value 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_window);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        
        //
        TextView t =(TextView) findViewById(R.id.helloWorldTextView);
        //t.setText("Not hello world");
        
        Intent intent = getIntent(); //inherited from Activity
        String s = intent.getStringExtra(THETEXT);
        t.setText(s);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_second_window, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
