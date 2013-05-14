package com.example.calculator;

import java.util.Stack;

public class CalculatorBrain {
	private static Stack <Double>stack;
	
	public CalculatorBrain()
	{
		stack = new Stack();
	}
	
	
	public Double pop(){
		
		return stack.pop();
	}
	
	public void push(Double s){
		stack.push(s);
		
	}
	public void clear(){
		stack.clear();
	}
	public boolean empty(){
		return stack.isEmpty();
	}
	
}

