package com.example.ing_medor.deuxiemedevoir.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ing_medor.deuxiemedevoir.Article;
import com.example.ing_medor.deuxiemedevoir.R;

;public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       //final String url = getIntent().getStringExtra("url");
        Article article = (Article) getIntent().getSerializableExtra("article");

         WebView webView = (WebView) findViewById(R.id.wvArticle);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
        webView.loadUrl(article.getWebUrl());


    }

}
