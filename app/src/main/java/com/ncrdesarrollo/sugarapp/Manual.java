package com.ncrdesarrollo.sugarapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;


public class Manual extends AppCompatActivity {

    TabHost tabs;
    TabHost.TabSpec tb1,tb2;

    final String urle = "https://drive.google.com/open?id=0B2cCzK3zLQ7BM0h2NnlCMTRydXM";
    final String urli = "https://drive.google.com/open?id=0B2cCzK3zLQ7BSzA2TnlsMW8xNEk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        Resources res = getResources();
        Resources res2 = getResources();
        Resources res3 = getResources();
        tabs = (TabHost)findViewById(R.id.tabHost);
        tabs.setup();

        tb1 = tabs.newTabSpec("tab1");
        tb1.setContent(R.id.linearLayout);
        tb1.setIndicator(getString(R.string.esss));
        tabs.addTab(tb1);

        tb2 = tabs.newTabSpec("tab2");
        tb2.setContent(R.id.linearLayout2);
        tb2.setIndicator(getString(R.string.innnn));
        tabs.addTab(tb2);


        WebView webe = (WebView)findViewById(R.id.webViewe);
        WebSettings settings = webe.getSettings();
        settings.setJavaScriptEnabled(true);
        webe.setWebViewClient(new MyWebViewCliente());
        webe.loadUrl(urle);


        WebView webi = (WebView)findViewById(R.id.webViewi);
        WebSettings settings2 = webi.getSettings();
        settings2.setJavaScriptEnabled(true);
        webi.setWebViewClient(new MyWebViewCliente());
        webi.loadUrl(urli);



    }


    private  class MyWebViewCliente extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
