package com.example.ath;

import java.util.List;

import com.example.ObjectModel.ATHObject;
import com.example.ObjectModel.SMSObject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class SMSObjectAdapter extends ArrayAdapter<SMSObject>{

	public SMSObjectAdapter(Context context, int resource,
			List<SMSObject> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) { 
			LayoutInflater vi = LayoutInflater.from(getContext()); 
			v = vi.inflate(R.layout.sms_item, null); 
		} 
		SMSObject p = getItem(position); 
		/*if (p != null) { 
			EditText dtsms = (EditText) v.findViewById(R.id.editTextSMS);
			
			if (dtsms != null) { 
				dtsms.setText(p.getSms()); 
			} 
		} */
		return v; 
	}
	
}
