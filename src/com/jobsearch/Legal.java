package com.jobsearch;

import com.jobsearch.Driver.Background;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Legal extends Activity{
	WebView webview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allcategories);
		
		new Background().execute();
	}

	public class Background extends AsyncTask{
		
		ProgressDialog progress=new ProgressDialog(Legal.this);
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
	        progress.setCancelable(true);
	        progress.setTitle("Accessing Driver Jobs");
	        progress.setMessage("Loading...");
	        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	        progress.setProgress(0);
	        progress.show();
	        super.onPreExecute();
		}
		
		@Override
		protected Object doInBackground(Object... arg0) {
			// TODO Auto-generated method stub
			webview=(WebView)findViewById(R.id.wvall);
			webview.getSettings().setJavaScriptEnabled(true);
			webview.getSettings().setLoadWithOverviewMode(false);
			webview.getSettings().setUseWideViewPort(true);
			webview.setWebViewClient(new LegalClient());
			webview.loadUrl("");		
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}

	}


private class LegalClient extends WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView webview, String url) {
		webview.loadUrl(url);
		return true;
	}
}

@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
	// TODO Auto-generated method stub
	if((keyCode==KeyEvent.KEYCODE_BACK)&& webview.canGoBack()){
		webview.goBack();
		return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
