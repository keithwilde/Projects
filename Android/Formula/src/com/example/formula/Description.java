package com.example.formula;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Description extends Activity {
	 	protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_description);
		    
		    //recieve the intent passed
		    Intent intent = getIntent();
		    //get the category passed
		    String descrName = intent.getExtras().getString("Name");
		    String descr = intent.getExtras().getString("Description");
		    
		    TextView name =new TextView(this); 
		    TextView description = new TextView(this);

		    name=(TextView)findViewById(R.id.name); 
		    description = (TextView)findViewById(R.id.description); 
		    
		    name.setText(descrName);
		    
		   
		    description.setText(Html.fromHtml(descr));
		    
		    
	 	}
	 	public void onBackPressed(){
	 		finish();
	 	}
}
