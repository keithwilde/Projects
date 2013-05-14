package com.example.formula;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

public class Formulas extends Activity {
	  ArrayList<String> names =new ArrayList<String>();
	  ArrayList<String> descriptions = new ArrayList<String>();
 protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_formulas);
		    
		    //recieve the intent passed
		    Intent intent = getIntent();
		    //get the category passed
		    String category = intent.getExtras().getString("Category");
		    Context context = getApplicationContext();
		    File file = new File(context.getFilesDir(), "data.txt");
		    ArrayList<String> nameAndDescription= new ArrayList<String>();
		  
			
	    	
		    if(file.exists()){
	    		nameAndDescription =readFromFile(category);
	    		
	    	}
		    
		    for(int i=0; i<nameAndDescription.size(); i ++){
		    	String tempNameDesc = nameAndDescription.get(i);
		    	String tempName = tempNameDesc.substring(0, tempNameDesc.indexOf("|"));
		    	String tempDescription = tempNameDesc.substring(tempNameDesc.indexOf("|")+1,tempNameDesc.length());
		    	names.add(tempName);
		    	descriptions.add(tempDescription);
		    	
		    }
	    				    		    		    
		    final ListView listview = (ListView) findViewById(R.id.formulas);		    		    
		    final ArrayList<String> list = names;
		    final StableArrayAdapter adapter = new StableArrayAdapter(this,
		        android.R.layout.simple_list_item_1, list);
		    listview.setAdapter(adapter);

		    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		     
		    

@Override
public void onItemClick(AdapterView<?> arg0, final View arg1, int arg2,long arg3) {    
				final String item = (String) arg0.getItemAtPosition(arg2);
				String tempDescription = "";
				if(!names.isEmpty() && !descriptions.isEmpty()){
					 tempDescription = descriptions.get(names.indexOf(item)); 
				}
				
				final String itemDescription = tempDescription;
				Intent i = new Intent(Formulas.this, Description.class);
				i.putExtra("Name", item);
				i.putExtra("Description", itemDescription);
				startActivity(i);
			}

		    });
		  }

private class StableArrayAdapter extends ArrayAdapter<String> {

		    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		    public StableArrayAdapter(Context context, int textViewResourceId,
		        List<String> objects) {
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
 private ArrayList<String> readFromFile(String category) {
	ArrayList <String> nameDescription = new ArrayList<String>();
		    String temp;
		    try {
		        InputStream inputStream = openFileInput("data.txt");
		        String receiveString = "";
		        if ( inputStream != null ) {
		            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	        
		           
		            
		            while ( (receiveString = bufferedReader.readLine()) != null ) {
		               
		            	 temp = receiveString.substring(0, receiveString.indexOf("|"));
		                 if(temp.equals(category)){
		                	 nameDescription.add(receiveString.substring(receiveString.indexOf("|")+1, receiveString.length()-1));
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
		    
		  
		   return nameDescription;
		}
 public void onBackPressed(){
		finish();
	}
 
}