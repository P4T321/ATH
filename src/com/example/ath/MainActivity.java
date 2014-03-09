package com.example.ath;

import java.util.ArrayList;
import java.util.List;

import com.example.ObjectModel.ATHObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

	List<ATHObject> liste;
	ListView listViewATH;
	ATHObjectAdapter adapter;
	Intent intentAjouter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Intents
		intentAjouter = new Intent(this, AddATHObject.class);
		
		//Views
		liste = new ArrayList<ATHObject>();
		listViewATH = (ListView) findViewById(R.id.listViewATH);
		
	    liste.add(new ATHObject(1, "Titre", "123-4567"));
	    liste.add(new ATHObject(2, "Titre", "123-4567"));
	    liste.add(new ATHObject(3, "Titre", "123-4567"));
	    liste.add(new ATHObject(4, "Titre", "123-4567"));
	    liste.add(new ATHObject(5, "Titre", "123-4567"));
	    
	    adapter = new ATHObjectAdapter(this, R.layout.listitem, liste);
	    listViewATH.setAdapter(adapter);  
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
        case R.id.itemAdd:
            startActivityForResult(intentAjouter, 1);
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainmenu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	
	
}
