package id.yusufrizalh.app005

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewActivity : AppCompatActivity() {
    private lateinit var myWeb: WebView
    private val url = "https://www.unsri.ac.id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        myWeb = findViewById(R.id.webView1)

        val settings = myWeb.settings

        settings.javaScriptEnabled = true
        settings.loadsImagesAutomatically = true

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.safeBrowsingEnabled = true
        }

        myWeb.fitsSystemWindows = true

        myWeb.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url!!)
                return true
            }
        }

        myWeb.loadUrl(url)

        fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            if (url.contains("https://www.unsri.ac.id")){
                view.loadUrl(url)
            } else {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
            return true
        }
    }
}