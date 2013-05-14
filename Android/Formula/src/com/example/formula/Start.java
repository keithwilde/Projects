package com.example.formula;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Start extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.start_view);

	}
public void buttonClicked(View v){
		String name = (String) ((android.widget.Button) v).getText();
		
		if(name.equals("New")){
			Intent i = new Intent(Start.this, Create.class);
			startActivity(i);
		}
		else{
			Intent i = new Intent(Start.this, Categories.class);
			startActivity(i);
		}
	 }
public void resetClicked(View v){
	 Context context = getApplicationContext();
	 File file = new File(context.getFilesDir(), "data.txt");
	 if(file.exists()){
 		file.delete();
 	}
	 Toast.makeText(getApplicationContext(), "Data Reset", Toast.LENGTH_LONG).show();
}
}
