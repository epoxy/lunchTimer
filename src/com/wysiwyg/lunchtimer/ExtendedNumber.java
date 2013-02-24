package com.wysiwyg.lunchtimer;

public class ExtendedNumber{
	private int number;
	public void setNumber(int nr){
		number=nr;
	}
	@Override
	public String toString(){
		return "Number: " + number;
	}
	public void decrement(){
		if(number!=0){
			number--;
		}
	}
	public int getNumber(){
		return number;
	}
	public static void main(String[] arg){
		ExtendedNumber[] n = new ExtendedNumber[6];
	}
	
}
