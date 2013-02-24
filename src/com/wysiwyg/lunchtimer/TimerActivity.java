package com.wysiwyg.lunchtimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TimerActivity extends Activity implements OnClickListener{

	private int timerStartValueMinutes, secondsLeftTotal, secondsLeftInitial, seconds, minutes;
	private int secondsOnes, secondsTens, minutesOnes, minutesTens, hoursOnes;
	private static CountDownTimer lunchTimer;
	private ImageButton cancelButton, restartButton, endButton, stopButton;
	private MainActivity mainActivity;
	private boolean timerRunning, timerShouldNotExist;
	private ImageView[] numberViews;
	private String imgString = "img", imgPicture;
	private int resID;
	private Drawable drawableNumber;
	private NumberContainer numbers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
		Intent intent = getIntent();
		
		//Buttons
		cancelButton = (ImageButton) findViewById(R.id.pauseButton);
		cancelButton.setOnClickListener((OnClickListener) this);
		restartButton = (ImageButton) findViewById(R.id.restartButton);
		restartButton.setOnClickListener((OnClickListener) this);
		endButton = (ImageButton) findViewById(R.id.endButton);
		endButton.setOnClickListener((OnClickListener) this);
		stopButton = (ImageButton) findViewById(R.id.stopButton);
		stopButton.setOnClickListener((OnClickListener) this);
		
		//ImageViews
		numberViews = new ImageView[6];
		numberViews[0] = (ImageView) findViewById(R.id.imageNr1);
		numberViews[1] = (ImageView) findViewById(R.id.imageNr2);
		numberViews[2] = (ImageView) findViewById(R.id.imageNr3);
		numberViews[3] = (ImageView) findViewById(R.id.imageNr4);
		numberViews[4] = (ImageView) findViewById(R.id.imageNr5);
		numberViews[5] = (ImageView) findViewById(R.id.imageNr6);
		
		if(lunchTimer==null){
			//Initiate timervalues
			timerStartValueMinutes = intent.getIntExtra("minutes", timerStartValueMinutes);
			secondsLeftTotal=timerStartValueMinutes*60;
			System.out.println("TESSSSSSSSSSSSST: " + timerStartValueMinutes);
			secondsLeftInitial = secondsLeftTotal;
			createTimer();
		}
	}

	private void createTimer() {
		numbers = new NumberContainer(secondsLeftTotal);
		System.out.println("1111");
		lunchTimer = new CountDownTimer(secondsLeftTotal*1000, 1000) {
			@Override
			public void onTick(long millisUntilFinished) {
				System.out.println("222");
				numbers.countDown();
				secondsLeftTotal = secondsLeftTotal - 1;
//				minutes = secondsLeftTotal/60;
//				minutesOnes = minutes%10;
//				minutesTens = minutes/10;
//				seconds = secondsLeftTotal%60;
//				secondsOnes = seconds%10;
//				secondsTens = seconds/10;
				System.out.println("" + minutes + ":" + seconds);
				
				for(int i=0; i<=5; i++){
					imgPicture = imgString + numbers.getNumber(i);
					resID = getResources().getIdentifier(imgPicture, "drawable", getPackageName());
					drawableNumber = getResources().getDrawable(resID);
					numberViews[i].setImageDrawable(drawableNumber);
				}
			}

			@Override
			public void onFinish() {
				System.out.println("00:00");
			}
		};
		lunchTimer.start();
		timerRunning = true;
		timerShouldNotExist = false;
	}

	@Override
	public void onClick(View v) {
		if(v==cancelButton){
			if(timerRunning){
				lunchTimer.cancel();
				timerRunning = false;
			}
			else{
				createTimer();
			}
			if(timerShouldNotExist){
				restart();
			}
		}
		if(v==restartButton){
			restart();
		}
		if(v==stopButton){
			timerShouldNotExist = true;
			lunchTimer.cancel();
			System.out.println("--:--");
		}
		if(v==endButton){
			lunchTimer=null;
			this.moveTaskToBack(true);
			android.os.Process.killProcess(android.os.Process.myPid());
		}
	}

	public void restart(){
		if(timerRunning){
			lunchTimer.cancel();
		}
		secondsLeftTotal = secondsLeftInitial;
		createTimer();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_timer, menu);
		return true;
	}


	public static CountDownTimer getTimer(){
		return lunchTimer;
	}

	public void onBackPressed() {
		if(timerShouldNotExist){
			lunchTimer=null;
			super.onBackPressed();
		}
		else{
			this.moveTaskToBack(true);
		}
	}
}
