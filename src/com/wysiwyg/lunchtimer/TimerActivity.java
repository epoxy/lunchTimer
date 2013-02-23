package com.wysiwyg.lunchtimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class TimerActivity extends Activity {
	
	private int timerStartValueMinutes, secondsLeftTotal, seconds, minutes;
	private CountDownTimer lunchTimer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
		Intent intent = getIntent();
		timerStartValueMinutes = intent.getIntExtra("minutes", timerStartValueMinutes);
		System.out.println("TESSSSSSSSSSSSST: " + timerStartValueMinutes);
		
		//Creating the timer
		secondsLeftTotal=timerStartValueMinutes*60;
		lunchTimer = new CountDownTimer(secondsLeftTotal*1000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				secondsLeftTotal = secondsLeftTotal - 1;
				minutes = secondsLeftTotal/60;
				seconds = secondsLeftTotal%60;
				System.out.println("" + minutes + ":" + seconds);
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				System.out.println("00:00");
			}
		};
		lunchTimer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_timer, menu);
		return true;
	}

}
