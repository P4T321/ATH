package com.example.ath;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.example.ObjectModel.SMSObject;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

public class AddATHObject extends Activity {

	//Constantes
	static final int TIME_DIALOG_ID = 0;
	static final int TIME_HOUR = 11;
	static final int TIME_MINUTE = 12;
	
	//Views
	EditText ETheureMin, ETheureMax;
	Button repeter;
	ListView ListViewSMS;
	
	//Variables locales
	int hour, minute, heureMinOuMax;
	static final int HEURE_MIN = 0, HEURE_MAX = 1;
	SMSObjectAdapter adapter;
	List<SMSObject> liste;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_athobject);
		
		ETheureMin = (EditText) findViewById(R.id.heureMin);
		ETheureMax = (EditText) findViewById(R.id.heureMax);
		repeter = (Button) findViewById(R.id.boutonRepeter);
		ListViewSMS = (ListView) findViewById(R.id.listViewSMS);

		liste = new ArrayList<SMSObject>();
		
		liste.add(new SMSObject(1, "Test"));
		
		adapter = new SMSObjectAdapter(this, R.layout.sms_item, liste);
		
		ListViewSMS.setAdapter(adapter);
		ETheureMin.setOnTouchListener(OnTouchListenerSelectionTemps);
		ETheureMax.setOnTouchListener(OnTouchListenerSelectionTemps);

		repeter.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				DialogFragment fragment = new SelectionJoursFragment();
				fragment.show(getFragmentManager(), "Jours");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_athobject, menu);
		return true;
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id, Bundle args) {
		switch (id){
		case TIME_DIALOG_ID:
			return new TimePickerDialog(this, mTimeSetListener, hour, minute, false);
		}
		return null;
	}
	
	private TimePickerDialog.OnTimeSetListener mTimeSetListener =
			new TimePickerDialog.OnTimeSetListener()
	{
		public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour)
		{		
			Calendar calendar = Calendar.getInstance();
			DateFormat dateFormatter = new DateFormat();
			String strDate;
			
			hour = hourOfDay;
			minute = minuteOfHour;
			calendar.set(TIME_HOUR, hour);   
			calendar.set(TIME_MINUTE, minute); 
			strDate = (String)dateFormatter.format("HH:mm", calendar.getTime());
			
			if (heureMinOuMax == HEURE_MIN)
				ETheureMin.setText(strDate);
			else if (heureMinOuMax == HEURE_MAX)
				ETheureMax.setText(strDate);
		}
	};
	
	//Listeners communs
	public OnTouchListener OnTouchListenerSelectionTemps = new OnTouchListener()
	{
		@Override
		public boolean onTouch(View view, MotionEvent arg1) {
			if (view.getId() == R.id.heureMin)
				heureMinOuMax = HEURE_MIN;
			else if (view.getId() == R.id.heureMax)
				heureMinOuMax = HEURE_MAX;
			showDialog(TIME_DIALOG_ID);
			return false;
		};
	};

}
