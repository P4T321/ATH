package com.example.ath;

import java.util.List;

import com.example.ObjectModel.ATHObject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ATHObjectAdapter extends ArrayAdapter<ATHObject>{

	public ATHObjectAdapter(Context context, int resource,
			List<ATHObject> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) { 
			LayoutInflater vi = LayoutInflater.from(getContext()); 
			v = vi.inflate(R.layout.listitem, null); 
		} 
		ATHObject p = getItem(position); 
		if (p != null) { 
			TextView ittv = (TextView) v.findViewById(R.id.textViewTitre); 
			TextView idtv = (TextView) v.findViewById(R.id.textViewNumTel); 
			
			if (ittv != null) { 
				ittv.setText(p.getTitre()); 
			} 
			if (idtv != null) { 
				idtv.setText(p.getNumTel()); 
			} 
		} 
		return v; 
	}
	
	

}
