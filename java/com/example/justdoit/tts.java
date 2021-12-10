package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class tts extends AppCompatActivity {
    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);
        String url = "https://justdoitandlisten.blogspot.com/p/todays-talk-show.html";

        web = findViewById(R.id.tts);
        web.getSettings().setJavaScriptEnabled(true);
       // web.getSettings().setLoadWithOverviewMode(true);
        web.getSettings().setUseWideViewPort(true);
       // web.getSettings().setBuiltInZoomControls(true);
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                webView.loadUrl(url);
                return true;
            }


        });
        web.loadUrl(url);
    }
}