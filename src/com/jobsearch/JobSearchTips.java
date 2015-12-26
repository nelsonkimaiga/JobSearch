package com.jobsearch;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class JobSearchTips extends Activity {
	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jobsearchtips);
		
		new Background().execute();
	}

	public class Background extends AsyncTask{
		
		ProgressDialog progress = new ProgressDialog(JobSearchTips.this);
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
	        progress.setCancelable(true);
	        progress.setTitle("Accessing Job Search Tips");
	        progress.setMessage("Loading...");
	        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	        progress.setProgress(0);
	        progress.show();
		}
		
		@Override
		protected Object doInBackground(Object... params) {
			// TODO Auto-generated method stub
			webView = (WebView) findViewById(R.id.wvjobsearchtips);
			webView.getSettings().setJavaScriptEnabled(true);
			webView.getSettings().setLoadWithOverviewMode(true);
			webView.getSettings().setUseWideViewPort(true);
			webView.loadUrl("http://www.recruitmentkenya.com/category/job-search-tips/");
			webView.setWebViewClient(new JobSearchTipsClient());
			return null;
		}

		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			progress.isShowing();
			
			
			super.onPostExecute(result);
		}
		
	}
	
	private class JobSearchTipsClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView webview, String url) {
			webview.loadUrl(url);
			return true;
		}
		 
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if((keyCode==KeyEvent.KEYCODE_BACK)&& webView.canGoBack()){
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	}


