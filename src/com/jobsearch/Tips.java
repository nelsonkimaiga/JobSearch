package com.jobsearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tips extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tips);
	}
	public void cvwriting(View view){
		Intent cv= new Intent(this, CvWriting.class);
		startActivity(cv);
	}
	public void interview(View view){
		Intent interview= new Intent(this, InterviewTips.class);
		startActivity(interview);
	}
	public void jobsearch(View view){
		Intent search=new Intent(this, JobSearchTips.class);
		startActivity(search);
	}
}
