package com.example.justdoit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Thirdfragment extends Fragment {
    TextView tvvv;
    public WebView w3;

    public Thirdfragment() {
// Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.thirdfragment, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvvv=view.findViewById(R.id.tv2);
        //tvvv.setText("NYC");
        w3=view.findViewById(R.id.w3);
        w3.setWebChromeClient(new WebChromeClient());
        w3.getSettings().setJavaScriptEnabled(true);
        w3.getSettings().setLoadWithOverviewMode(true);
        w3.getSettings().setUseWideViewPort(true);
        w3.getSettings().setBuiltInZoomControls(true);
        w3.setWebViewClient(new WebViewClient()
        {
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url)
            {
                webView.loadUrl(url);
                return true;
            }


        });
        w3.loadUrl("https://www.nbcnewyork.com");
    }

}
