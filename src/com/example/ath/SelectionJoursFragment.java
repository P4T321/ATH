package com.example.ath;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class SelectionJoursFragment extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
	    final List mSelectedItems = new ArrayList();  
	    
	    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

	    builder.setTitle(R.string.Jours)
	           .setMultiChoiceItems(R.array.JoursSemaine, null,
	                      new DialogInterface.OnMultiChoiceClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int which, boolean isChecked) 
	               {
	                   if (isChecked) 
	                       mSelectedItems.add(which);
	                   else if (mSelectedItems.contains(which)) 
	                       mSelectedItems.remove(Integer.valueOf(which));    
	               }
	           })

	           .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	                   // User clicked OK, so save the mSelectedItems results somewhere
	                   // or return them to the component that opened the dialog
	                   //...
	            	   //CODE À AJOUTER
	               }
	           })
	           .setNegativeButton(R.string.annuler, new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	                   //...
	            	   //CODE À AJOUTER
	               }
	           });

	    return builder.create();
	    
	}
	
	

}
