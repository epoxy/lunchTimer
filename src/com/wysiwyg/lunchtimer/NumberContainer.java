package com.wysiwyg.lunchtimer;

import android.widget.ImageView;

public class NumberContainer {
	private int secondsLeftTotal;
	private ExtendedNumber[] numbers;
	public NumberContainer(int secondsLeftTotal){
			
		this.secondsLeftTotal=secondsLeftTotal;
		numbers = new ExtendedNumber[6];
		for(int i=0; i<=5; i++){
			numbers[i] = new ExtendedNumber();
		}
		int hours = secondsLeftTotal/3600;
		int secondsRestHours = secondsLeftTotal%3600;
		numbers[0].setNumber(hours/10);
		numbers[1].setNumber(hours%10);
		int minutes = secondsRestHours/60;
		int seconds = secondsRestHours%60;
		numbers[2].setNumber(minutes/10);
		numbers[3].setNumber(minutes%10);
		numbers[4].setNumber(seconds/10);
		numbers[5].setNumber(seconds%10);
	}
	public void countDown(){
		secondsLeftTotal--;
		int hours = secondsLeftTotal/3600;
		int secondsRestHours = secondsLeftTotal%3600;
		numbers[0].setNumber(hours/10);
		numbers[1].setNumber(hours%10);
		int minutes = secondsRestHours/60;
		int seconds = secondsRestHours%60;
		numbers[2].setNumber(minutes/10);
		numbers[3].setNumber(minutes%10);
		numbers[4].setNumber(seconds/10);
		numbers[5].setNumber(seconds%10);
	}
	public int getNumber(int identifier){
		return numbers[identifier].getNumber();
	}
//	seconds2.setImageResource(R.id.)
//	catPicture = catPictureString + "closed";
//	resID = getResources().getIdentifier(catPicture, "drawable", getPackageName());
//	drawableCat = getResources().getDrawable(resID);
//	relativeLayout.setBackgroundDrawable(drawableCat);
}
