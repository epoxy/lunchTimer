package com.wysiwyg.lunchtimer;

public class NumberContainer<ExtendedNumber> {
	private int secondsLeftTotal;
	private ExtendedNumber[] numbers;
	public NumberContainer(int secondsLeftTotal){
		numbers = new ExtendedNumber[6];
		this.secondsLeftTotal=secondsLeftTotal;
		int hours = secondsLeftTotal/3600;
		int secondsRestHours = secondsLeftTotal%3600;
		numbers[0].setNumber(hours/10);
		numbers[1] = hours%10;
		int minutes = secondsRestHours/60;
		int seconds = secondsRestHours%60;
		numbers[2] = minutes/10;
		numbers[3] = minutes%10;
		numbers[4] = seconds/10;
		numbers[5] = seconds%10;
	}
	public void countDown(){
		//numbers[5].
	}
//	seconds2.setImageResource(R.id.)
//	catPicture = catPictureString + "closed";
//	resID = getResources().getIdentifier(catPicture, "drawable", getPackageName());
//	drawableCat = getResources().getDrawable(resID);
//	relativeLayout.setBackgroundDrawable(drawableCat);
}
