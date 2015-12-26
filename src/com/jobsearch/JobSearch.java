package com.jobsearch;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class JobSearch extends Activity{
	EditText etsearch;
	Button bsearch , availablejobs, categories;
	ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_job_search);
		categories=(Button)findViewById(R.id.bcategories);
	}

			
			public void category(View view) {
				// TODO Auto-generated method stub
				Intent category= new Intent(this, Categories.class);
				startActivity(category);
			}
			

	
	public void availablejobs(View view){
		Intent available= new Intent(this, Availablejobs.class);
		startActivity(available);
	}
	public void tips(View view){
		Intent tips=new Intent(this, Tips.class);
		startActivity(tips);
	}
}
