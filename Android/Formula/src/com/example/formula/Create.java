package com.example.formula;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import android.widget.Button;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class Create extends Activity {
	public ArrayList<String> [] categoryNameDesc;
	public File file = null;
	private String fileContents = "";
	InputStream fis = null;
	ObjectInputStream ois = null;
	

	protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.create_edit);
		    
		    
	Context context = getApplicationContext();
		    
	readFile(context);
	String [] dropDownOptions = {"Physics", "Algebra", "Geometry","Chemistry","Miscellaneous"};
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,dropDownOptions);   
	AutoCompleteTextView actvDev = (AutoCompleteTextView)findViewById(R.id.add_category);
	actvDev.setThreshold(1);
	actvDev.setAdapter(adapter);
		        
		        
		    
	}
	  
	  	

private  void readFile(Context context) {
	
	file = new File(context.getFilesDir(), "data.txt");
    if(file.exists()){
        try {
            InputStream inputStream = openFileInput("data.txt");
            String receiveString = "";
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                          
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                  		fileContents +=receiveString+"\n";  
                }
                
                inputStream.close(); 
            }
           
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
    }
   	
}


	@SuppressLint("NewApi")
public void enterClicked(View v){
		
		//get the values in add_category,add_formula_name, and add_formula and save them
		TextView cat = (TextView) findViewById(R.id.add_category);
	    TextView name = (TextView) findViewById(R.id.add_formula_name);
	    TextView form = (TextView) findViewById(R.id.add_formula);
	    
	    String category = cat.getText().toString();
	    String formulaName = name.getText().toString();
	    String formula = form.getText().toString();
	    
	    
	    	    
	    //if all empty don't do anything but return to first view
	    //if not set the empties to defaultFormulaName or DefaultFormula or something and return to first view
	    if(!formula.isEmpty() && !formulaName.isEmpty()){
	    	saveValues(category,formulaName,formula);
	    	Toast.makeText(getApplicationContext(), "Formula Added", Toast.LENGTH_LONG).show();
	    
	    }
		cat.setText("");
    	name.setText("");
    	form.setText("");   
			
	}
	 //when something is selected bring up a list of current things available to it

public void cancelClicked(View v){
	
	//Intent i = new Intent(Create.this, Start.class);
	//startActivity(i);
	finish();
	}

public void symbolClicked(View v){
	TextView t = (TextView) findViewById(R.id.add_formula);
	
	
		Button b = (Button) v;
		String buttonText = b.getText().toString();
		Log.v("button",buttonText);
		t.append(buttonText);

	
}

public void saveValues(String cat, String name, String description ){
		
	
	try {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("data.txt", Context.MODE_PRIVATE));     
        	outputStreamWriter.write(fileContents);
        	outputStreamWriter.write(cat + "|" + name + "|" + description + "|\n");
        	outputStreamWriter.close();
        	
    }
    catch (IOException e) {
        Log.e("Exception", "File write failed: " + e.toString());
    } 
	fileContents = fileContents + cat + "|" + name + "|" + description + "|\n";
}
}

