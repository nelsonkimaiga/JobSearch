package com.jobsearch;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CvWriting extends Activity {
	private WebView webView;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cvwriting);
		webView = (WebView) findViewById(R.id.wvcvwriting);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);

		webView.setWebViewClient(new CvWritingClient());
		new BackgroundActivity().execute();
	}

	private class CvWritingClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView webview, String url) {
			webview.loadUrl(url);
			return true;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	private class BackgroundActivity extends AsyncTask {
		ProgressDialog progressDialog = new ProgressDialog(CvWriting.this);
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			progressDialog.setCancelable(true);
			progressDialog.setMessage("Loading...");
			progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progressDialog.setProgress(0);
			progressDialog.show();
			super.onPreExecute();
			
			
		}

		@Override
		protected Object doInBackground(Object... params) {
			// TODO Auto-generated method stub
			webView.loadUrl("http://www.recruitmentkenya.com/category/cv-writing/");
			return null;
		}

		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			
			super.onPostExecute(result);

			
			

		}
	}

}
