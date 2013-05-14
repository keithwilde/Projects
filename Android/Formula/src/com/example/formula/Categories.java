package com.example.formula;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Categories extends Activity {
	public ArrayList<String> [] categoryNameDesc;
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_categories);

	    
	    //read from file
	    Context context = getApplicationContext();
	    File file = new File(context.getFilesDir(), "data.txt");
	    ArrayList<String> values =new ArrayList<String>();
		//file.delete();
    	if(file.exists()){
    		values = readFromFile();
    	}
    	else{
    		writeToFile();
    		values = readFromFile();
    	}
    	
	      
	    
	    final ListView listview = (ListView) findViewById(R.id.categories);
	   
	    final ArrayList<String> list = values;
	    		
	    
	    final StableArrayAdapter adapter = new StableArrayAdapter(this,
	        android.R.layout.simple_list_item_1, list);
	    
	    listview.setAdapter(adapter);
	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	     
	    

		@Override
		public void onItemClick(AdapterView<?> arg0, final View arg1, int arg2,long arg3) {    
			final String item = (String) arg0.getItemAtPosition(arg2);
			
			//start the formula activity
			Intent i = new Intent(Categories.this, Formulas.class);
			i.putExtra("Category", item);
			startActivity(i);
		}

	    });
	  }
	
private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId, List<String> objects) {
	      super(context, textViewResourceId, objects);
	      for (int i = 0; i < objects.size(); ++i) {
	        mIdMap.put(objects.get(i), i);
	      }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }

	  }
private void writeToFile() {
    try {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("data.txt", Context.MODE_PRIVATE));
       
	    String [] array1 = {"Geometry", "Area of Circle", "Pir^2"};
	    String [] array2 = {"Geometry", "Circumferences of a Circle", "2Pir"};
	    String [] array3 = {"Geometry", "Diameter of Circle", "2r"};
	    
	    String [] array4 = {"Physics", "Speed of Light", "c =3.00  x 10^8 m s"};
	    String [] array5 = {"Physics", "Conservation of Energy", "KE + PE = constant"};
	    String [] array6 = {"Physics",  "Gravity", "9.8 m/s2"};
	    
	    String [] array7 = {"Algebra", "Equation 1", "x^2 =1"};
	    String [] array8 = {"Algebra", "Equation 2", "y = x+3"};
	    String [] array9 = {"Algebra",  "Equation 3", "y = 4x^2 + (2x-1)^2"};
	    
	    String [] array10 = {"Chemistry", "Density", "d = m/V"};
	    String [] array11 = {"Chemistry", "Boyles's Law", "PV =k"};
	    String [] array12 = {"Chemistry",  "Avogadro’s law", "V = kn"};
	    
	    String [] array13 = {"Miscellaneous", "Useless Formula", "x = x"};
	    String [] array14 = {"Miscellaneous", "Even more useless formula", "0 < 2 "};
	    String [] array15 = {"Miscellaneous",  "Other ", "y + x + z =2 "};
	    String [][]arrays = {array1, array2, array3, array4,array5,array6,array7,array8,array9,array10,array11,array12,array13,array14,array15};
       
       
        for(int i =0; i <arrays.length; i++){
        	for(int j = 0; j<3; j++){
        		
        		outputStreamWriter.write(arrays[i][j] + "|");
        	}
        	outputStreamWriter.write("\n");
        }
        
        outputStreamWriter.close();
    }
    catch (IOException e) {
        Log.e("Exception", "File write failed: " + e.toString());
    } 
}



private ArrayList<String> readFromFile() {
	ArrayList <String> catList = new ArrayList<String>();
    
	String temp = "";
    try {
        InputStream inputStream = openFileInput("data.txt");
        String receiveString = "";
        if ( inputStream != null ) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                      
            while ( (receiveString = bufferedReader.readLine()) != null ) {
               
                temp = receiveString.substring(0, receiveString.indexOf("|"));
                if(!catList.contains(temp)){
                	catList.add(temp);
                }          
               
            }
            
            inputStream.close();
           
        }
       
    }
    catch (FileNotFoundException e) {
        Log.e("login activity", "File not found: " + e.toString());
    } catch (IOException e) {
        Log.e("login activity", "Can not read file: " + e.toString());
    }
    
  
   return catList;
}

	} 