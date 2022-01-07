package com.ncrdesarrollo.sugarapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Mapa extends AppCompatActivity {

    final String url = "https://www.google.es/maps/place/2%C2%B015'17.2%22N+75%C2%B035'48.2%22W/@2.2547974,-75.5989197,743m/data=!3m2!1e3!4b1!4m5!3m4!1s0x0:0x0!8m2!3d2.254792!4d-75.596731";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        WebView web = (WebView)findViewById(R.id.webmapa);
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.setWebViewClient(new MyWebViewClient());
        web.loadUrl(url);
    }

    private  class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }
}
