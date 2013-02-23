package com.wysiwyg.lunchtimer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener{

	private ImageButton thirtyMinsButton, sixtyMinsButton, customButton;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Buttons
		thirtyMinsButton = (ImageButton) findViewById(R.id.imageButton1);
		sixtyMinsButton = (ImageButton) findViewById(R.id.imageButton2);
		customButton = (ImageButton) findViewById(R.id.imageButton3);
		thirtyMinsButton.setOnClickListener((OnClickListener) this);
		sixtyMinsButton.setOnClickListener((OnClickListener) this);
		customButton.setOnClickListener((OnClickListener) this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v==thirtyMinsButton){
			System.out.println("30 mins!");
			intent = new Intent(this, TimerActivity.class);
			intent.putExtra("minutes", 30);
			startActivity(intent);
		}
		if(v==sixtyMinsButton){
			System.out.println("60 mins!");
			intent = new Intent(this, TimerActivity.class);
			intent.putExtra("minutes", 60);
			startActivity(intent);
		}
		if(v==customButton){
			System.out.println("Custom!");
			//TODO gör detta värde valbart!
			intent = new Intent(this, TimerActivity.class);
			intent.putExtra("minutes", 45);
			startActivity(intent);
		}
	}

}
