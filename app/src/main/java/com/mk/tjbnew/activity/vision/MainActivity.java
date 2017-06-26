package com.mk.tjbnew.activity.vision;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mk.tjbnew.R;
import com.mk.tjbnew.activity.BaseActivity;


public class MainActivity extends AppCompatActivity{//AppCompatActivity {

    protected WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //TODO web视图处理
        //webView初始化
        webViewInit();
    }

    /**
     * webView初始化
     */
    private void webViewInit(){
        webView = (WebView) findViewById(R.id.webView);

        //web设置
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result)
            {
                return super.onJsAlert(view,url,message,result);
            }
            @Override
            public void onReceivedTitle(WebView view, String url) {
                MainActivity.this.setTitle(webView.getTitle());
            }
        });

        //WebView加载web资源
        webView.loadUrl("http://211.149.155.83:8001/Vision/ColorBlindness");
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                MainActivity.this.setTitle(webView.getTitle());
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
