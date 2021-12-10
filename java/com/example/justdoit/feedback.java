package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

public class feedback extends AppCompatActivity {
    WebView feedbackwebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        feedbackwebview=findViewById(R.id.feedbackwebview);
        //String url="https://docs.google.com/forms/d/e/1FAIpQLSdlFrMMY8glXQhq5VlMpOjNF3VKLWn35b9JKFuvXNkKirsD8g/viewform";
        Intent intent = getIntent();
        String url = intent.getStringExtra("link");
        //String unencodedHtml ="<head><body> </body></head>";
        //String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(),
         //       Base64.NO_PADDING);
        //feedbackwebview.loadData(encodedHtml,  "text/html","base64");

        feedbackwebview.getSettings().setJavaScriptEnabled(true);
        feedbackwebview.getSettings().setLoadWithOverviewMode(true);
        feedbackwebview.getSettings().setUseWideViewPort(true);
        feedbackwebview.getSettings().setBuiltInZoomControls(true);

        feedbackwebview.setWebChromeClient(new WebChromeClient());
        feedbackwebview.setWebViewClient(new WebViewClient()
        {
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url)
            {
                webView.loadUrl(url);
                return true;
            }


        });
        feedbackwebview.loadUrl(url);

    }
}