package com.jobsearch;



import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Search extends Activity{
WebView webview;
ProgressDialog progressDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		webview=(WebView)findViewById(R.id.wvsearch);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setLoadWithOverviewMode(true);
		webview.getSettings().setUseWideViewPort(true);
	}
	
	public class BackgroundAsyncTask extends AsyncTask <Void, Void, Void>{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressDialog = new ProgressDialog(Search.this);
	        progressDialog.setCancelable(true);
	        progressDialog.setMessage("Loading...");
	        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	        progressDialog.setProgress(0);
	        progressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			webview.loadUrl("http://recruitmentkenya.com");
			webview.setWebViewClient(new SearchClient());
			
			return null;
		}
		
		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			 progressDialog.dismiss();
		}
		
		private class SearchClient extends WebViewClient {
			@Override
			public boolean shouldOverrideUrlLoading(WebView webview, String url) {
				webview.loadUrl(url);
				return true;
			}
			
			
		
}
		}
	}
	
	
