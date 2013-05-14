package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	CalculatorBrain calcBrain = new CalculatorBrain();
	boolean userEnteringNumber = false;					//false when a user is entering a number, true when they are not
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
   
    
    public void buttonClicked(View v){
    	//transition
    	
    	//Intent intent = new Intent(this, SecondWindow.class);
    	//intent.putExtra(SecondWindow.THETEXT, "Here are some words");
    	//startActivity(intent);
    	
    	
    	TextView t = (TextView) findViewById(R.id.textView1);
    	TextView log = (TextView) findViewById(R.id.textViewLog);
    	
    	if(v == findViewById(R.id.button0)){
    		if(userEnteringNumber){
    			t.setText(((Button) v).getText());
    			userEnteringNumber=false;
    		}else{    			
    			t.append(((Button) v).getText());
    		}
    		
    		
    	}
    	else if(v == findViewById(R.id.button1)){
    		if(userEnteringNumber){
    			t.setText(((Button) v).getText());
    			userEnteringNumber=false;
    		}else{
    			t.append(((Button) v).getText());
    		}
    		
    	
    	}
    	else if(v == findViewById(R.id.button2)){
    		if(userEnteringNumber){
    			t.setText(((Button) v).getText());
    			userEnteringNumber=false;
    		}else{
    			t.append(((Button) v).getText());
    		}
    		
    	
    	}
    	else if(v == findViewById(R.id.button3)){
    		if(userEnteringNumber){
    			t.setText(((Button) v).getText());
    			userEnteringNumber=false;
    		}else{
    			t.append(((Button) v).getText());
    		}
    		
    	
    	}
    	else if(v == findViewById(R.id.button4)){
    		if(userEnteringNumber){
    			t.setText(((Button) v).getText());
    			userEnteringNumber=false;
    		}else{
    			t.append(((Button) v).getText());
    		}
    		
    	
    	}
    	else if(v == findViewById(R.id.button5)){
    		if(userEnteringNumber){
    			t.setText(((Button) v).getText());
    			userEnteringNumber=false;
    		}else{
    			t.append(((Button) v).getText());
    		}
    		
    	
    	}
    	else if(v == findViewById(R.id.button6)){
    		if(userEnteringNumber){
    			t.setText(((Button) v).getText());
    			userEnteringNumber=false;
    		}else{
    			t.append(((Button) v).getText());
    		}
    		
    	
    	}
    	else if(v == findViewById(R.id.button7)){
    		if(userEnteringNumber){
    			t.setText(((Button) v).getText());
    			userEnteringNumber=false;
    		}else{
    			t.append(((Button) v).getText());
    		}
    	
    	}
    	else if(v == findViewById(R.id.button8)){
    		if(userEnteringNumber){
    			t.setText(((Button) v).getText());
    			userEnteringNumber=false;
    		}else{
    			t.append(((Button) v).getText());
    		}
    	
    	}
    	else if(v == findViewById(R.id.button9)){
    		if(userEnteringNumber){
    			t.setText(((Button) v).getText());
    			userEnteringNumber=false;
    		}else{
    			t.append(((Button) v).getText());
    		}
    	
    	}
    	else if(v == findViewById(R.id.buttonDecimal)){
    		if(t.getText().toString().indexOf(".") == -1){
    			t.append(((Button) v).getText());
    		}
    		
    	
    	}
    	else if(v == findViewById(R.id.buttonM)){
    		double num1,num2;
    		if(t.getText().toString().isEmpty()){
    			num1 =0;
    			log.append("0 ");
    		}
    		else{
    			num1 = Double.parseDouble(t.getText().toString());
    			log.append(t.getText());
    		}
    		if(calcBrain.empty()){
    			num2 = 0;
    		}
    		else{
    			num2 = calcBrain.pop();
    		}
    		double product = num1 * num2;
    		calcBrain.push(product);
    		t.setText(" = " +Double.toString(product));
    		log.append(" * ");
    		userEnteringNumber = true;
    	
    	}
    	else if(v == findViewById(R.id.buttonD)){
    		double divisor, quotient;
    		if(t.getText().toString().isEmpty()){
    			quotient = 0;
    			log.append("0 ");
    		}
    		else{
    			
    			divisor = Double.parseDouble(t.getText().toString());
    			log.append(t.getText());
    			quotient = calcBrain.pop() / divisor;
    			
    		}
    		calcBrain.push(quotient);
			t.setText(" = "+ Double.toString(quotient));
    		
    		log.append(" / ");
    		userEnteringNumber = true;
    	
    	}
     	else if(v == findViewById(R.id.buttonA)){
    		double num1,num2,sum;
    		if(t.getText().toString().isEmpty()){
    			num2 = 0;
    			log.append("0 ");
    		}
    		else{
    			num2 = (Double.parseDouble(t.getText().toString()));
    			log.append(t.getText());
    		}
    		if(calcBrain.empty()){
    			num1=0;
    		}
     		else{
     			num1 = calcBrain.pop();
     			    			
     		}
     		
    		sum = num1+num2;
    		calcBrain.push(sum);
    		t.setText(" = " +Double.toString(sum));
    		userEnteringNumber=true;
    		log.append(" + ");
    	
    	}
    	
    	else if(v == findViewById(R.id.buttonMinus)){
    		double minuend, subtrahend;
    		if(t.getText().toString().isEmpty()){
    			subtrahend = 0;
    			log.append("0 ");
    		}
    		else{
    			subtrahend = Double.parseDouble(t.getText().toString());
    			log.append(t.getText());
    		}
    	
    		if(calcBrain.empty()){
    			minuend = 0;
    		}
    		else{
    			minuend = calcBrain.pop();
    		}
    		double difference = minuend - subtrahend;
    		calcBrain.push(difference);
    		t.setText(" = " +Double.toString(difference));
    		userEnteringNumber=true;
    		log.append(" - ");

    	}
    
    
    
    	else if(v == findViewById(R.id.buttonSin)){
    		double sine,num;
    		if(t.getText().toString().isEmpty()){
    			num=0;
    			log.append("0 ");
    		}
    		else{
    			num = Double.parseDouble(t.getText().toString());
    			
    		}
    		sine = Math.sin(num);
    		t.setText(" = " +Double.toString(sine));
    		calcBrain.push(sine);
    		log.append(" = " + num +" Sin ");
    		userEnteringNumber=true;
    	
    	}
    	else if(v == findViewById(R.id.buttonCos)){
    		double cosine,num;
    		if(t.getText().toString().isEmpty()){
    			num=0;
    			log.append("0 ");
    		}
    		else{
    			num = Double.parseDouble(t.getText().toString());
    			
    		}
    		cosine = Math.cos(num);
    		t.setText(" = " +Double.toString(cosine));
    		calcBrain.push(cosine);
    		log.append(num+" Cos ");
    		userEnteringNumber=true;
    	
    	}
    	else if(v == findViewById(R.id.buttonSqrt)){
    		
    		double result;
    		double num1 = 0;
    		
    		
    		if(t.getText().toString().isEmpty()){
    			result = 0;
    			log.append("0 ");
    		}
    		else{
    			num1 = Double.parseDouble(t.getText().toString());
    			result = Math.sqrt(num1);
    		}
    		
    		t.setText(" = " +Double.toString(result));
    		calcBrain.push(result);
    		log.append(num1+ " Sqrt ");
    		userEnteringNumber=true;
    	
    	}
    	else if(v == findViewById(R.id.buttonPi)){
    		//if(t.getText().toString().equals("Pi")){
    		//calcBrain.push(3.14159);
    		t.setText("Pi");
    		userEnteringNumber=true;
    		//}    	
    	}
    	else if(v == findViewById(R.id.buttonClear)){
    		t.setText("0");
    		log.setText("");
    		calcBrain.clear();
    		userEnteringNumber=false;
    	}
    	else if(v == findViewById(R.id.backspace)){
    		
    		int length = t.getText().length();
    		t.setText(t.getText().subSequence(0, length-1 ));
    		userEnteringNumber=true;
    		    	
    	}
    	else if(v == findViewById(R.id.plusMinus)){
    		double temp = (Double.parseDouble(t.getText().toString()));
    		temp = temp * -1;
    		calcBrain.push(temp);
    		t.setText(Double.toString(temp));
    		userEnteringNumber=true;
    		    	
    	}
    	
    	else if(v == findViewById(R.id.buttonEnter)){
    		if(!t.getText().toString().equals("")){
    			if(!t.getText().toString().equals("Pi")){
    				calcBrain.push(Double.parseDouble(t.getText().toString()));
    			}
    			else if(t.getText().toString().equals("Pi")){
    				calcBrain.push(3.14159);
    				t.setText(Double.toString(3.14159));
    			}
    			if(t.getText().charAt(0) == '0'){
    				String temp = t.getText().toString();
    				log.append(temp.substring(1) + " ");
    			}else{
    			
    			log.append(t.getText() + " ");
    			}
    			t.setText("");
    		
    		}
    		userEnteringNumber=false;
    		
    	}
    	
    	   	
    	
    }
}
