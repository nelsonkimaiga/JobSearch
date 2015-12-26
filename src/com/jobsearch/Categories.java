package com.jobsearch;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Categories extends ListActivity {

	String classes[] = { "Academic", "Accounting", "Administration",
			"Advocates", "Architect", "Banking",
			"Business_Development", "Cabin_Crew", "CEO_Jobs",
			"Chief_Finance_Officer", "Clinical_Officer", "Driver",
			"General_Jobs", "General_Technician", "Human_Resource",
			"Information_Technology", "Legal", "Medical", "Management",
			"Political Analyst", "Procurement", "WebDesign", "Teaching",
			"Secretary" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Categories.this,
	    android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];
		try {
			Class ourClass = Class.forName("com.jobsearch." + cheese);
			Intent ourIntent = new Intent(Categories.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

	}

}
