package com.jobsearch;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Availablejobs extends Activity {
	WebView webView;
	ProgressDialog progress;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.availablejobs);
		webView = (WebView) findViewById(R.id.wvavailablejobs);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.setWebViewClient(new AvailablejobsClient());
		new Background().execute(); 
	}
		public class Background extends AsyncTask{
			
			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				progress = new ProgressDialog(Availablejobs.this);
		        progress.setCancelable(true);
		        progress.setTitle("Accessing Available Jobs");
		        progress.setMessage("Loading...");
		        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		        progress.setProgress(0);
		        progress.show();
			}
			
			@Override
			protected Object doInBackground(Object... arg0) {
				// TODO Auto-generated method stub
				
				webView.loadUrl("http://recruitmentkenya.com");		
				
				return null;
			}

			@Override
			protected void onProgressUpdate(Object... values) {
				// TODO Auto-generated method stub
				super.onProgressUpdate(values);
			
			}
			
			@Override
			protected void onPostExecute(Object result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
			}
	
		}
	
	
	private class AvailablejobsClient extends WebViewClient {
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


