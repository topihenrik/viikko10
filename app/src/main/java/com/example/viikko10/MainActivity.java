package com.example.viikko10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etSearchBox;
    WebView web;
    SiteHistory siteHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        siteHistory = new SiteHistory();
        etSearchBox = findViewById(R.id.etSearchBox);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://www.google.com/");
        siteHistory.newSiteUpdateHistory("https://www.google.com/");
    }

    public void goButton(View view) {
        String url = etSearchBox.getText().toString();
        if (url.isEmpty()) {
            return;
        } else if (url.equals("index.html")) {
            web.loadUrl("file:///android_asset/index.html");
            siteHistory.newSiteUpdateHistory("file:///android_asset/index.html");
        } else if ((url.contains("https://")) || (url.contains("http://"))) {
            web.loadUrl(url);
            siteHistory.newSiteUpdateHistory(url);
        } else {
            web.loadUrl("http://" + url);
            siteHistory.newSiteUpdateHistory("http://" + url);
        }
    }

    public void refreshButton(View view) {
        web.loadUrl(web.getUrl());
    }

    public void shoutOutButton(View view) {
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void initializeButton(View view) {
        web.evaluateJavascript("javascript:initialize()", null);
    }

    public void backButton(View view) {
        web.loadUrl(siteHistory.getPreviousSite());
    }

    public void forwardButton(View view) {
        web.loadUrl(siteHistory.getNextSite());
    }
}