package com.jobsearch;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InterviewTips extends Activity {
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interviewtips);
		
		new Background().execute();
	}

	public class Background extends AsyncTask{
		
		ProgressDialog progress= new ProgressDialog(InterviewTips.this);
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			progress.setCancelable(true);
			progress.setTitle("Accessing Interview Tips");
			progress.setMessage("Loading...");
			progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progress.setProgress(0);
			progress.show();
			super.onPreExecute();
		}
		
		@Override
		protected Object doInBackground(Object... arg0) {
			// TODO Auto-generated method stub
			webView = (WebView) findViewById(R.id.wvinterviewtips);
			webView.getSettings().setJavaScriptEnabled(true);
			webView.getSettings().setLoadWithOverviewMode(true);
			webView.getSettings().setUseWideViewPort(true);
			webView.loadUrl("http://www.recruitmentkenya.com/category/interview-tips/");
			webView.setWebViewClient(new InterviewTipsClient());
			return null;
		}

		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}

		
		
	}
	
	private class InterviewTipsClient extends WebViewClient {
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
