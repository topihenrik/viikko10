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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearchBox = findViewById(R.id.etSearchBox);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://www.google.com/");
        //https://www.google.com/
        //file:///android_asset/index.html
    }

    public void goButton(View view) {
        String url = etSearchBox.getText().toString();
        if (url.isEmpty()) {
            return;
        } else if ((url.contains("https://")) || (url.contains("http://"))) {
            web.loadUrl(url);
        } else {
            web.loadUrl("http://" + url);
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
}