package com.oparabenjamin.alc;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.SslErrorHandler;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AlcAboutActivity extends AppCompatActivity {
    private WebView mWebView;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alc_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About ALC");

        mWebView = findViewById(R.id.web_view);
        mWebView.setWebViewClient(new MyBrowser());
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebView.loadUrl("https://www.andela.com/alc");
        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onPause() {

        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("webViewUrl", mWebView.getUrl());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String webViewUrl = savedInstanceState.getString("webViewUrl");
        Toast.makeText(this, webViewUrl, Toast.LENGTH_SHORT).show();
        mWebView.loadUrl(webViewUrl);
    }


    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            count = 1;
            mWebView.goBack();
        } else {
            if (count == 0) {
                Toast.makeText(this, "press one more time to exit app", Toast.LENGTH_SHORT).show();
                count++;
            } else {
                super.onBackPressed();
            }
        }
    }

    public class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();


        }
    }
}