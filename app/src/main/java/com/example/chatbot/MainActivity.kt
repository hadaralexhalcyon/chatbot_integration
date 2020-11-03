package com.example.chatbot

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.chatbot.databinding.ActivityMainBinding
import org.intellij.lang.annotations.Language

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
            setupWebview(this.webview)
        }
    }

    private fun setupWebview(webview: WebView) = webview.apply {
        //noinspection SetJavaScriptEnabled
        settings.javaScriptEnabled = true
        loadDataWithBaseURL(null, SCRIPT, MIME, ENCODING, null)
    }

    companion object {
        private const val KEY = "YOUR_KEY_HERE"
        private const val STORY_ID = "YOUR_STORY_ID_HERE"

        private const val MIME = "text/html"
        private const val ENCODING = "utf-8"

        @Language("HTML")
        private const val SCRIPT = """
            <!DOCTYPE html>
            <html lang="en">
            
            <head>
              <script>
                !function () {
                  var t; if (t = window.webbot = window.webbot = window.webbot || [], !t.init) return t.invoked ? void (window.console && console.error && console.error("Webbot snippet included twice.")) : (
                    t.load = function (e, s, bg) {
                      var o, n; o = document.createElement("script"); e.type = "text/javscript"; o.async = !0; o.crossorigin = "anonymous";
                      o.src = "https://botdash.disruptionworks.co.uk/web-bot/script/embed/" + e + "/" + s + "/" + bg + "/webbot.js"; n = document.getElementsByTagName("script")[0]; n.parentNode.insertBefore(o, n);
                    });
                }(); webbot.load('$KEY', '$STORY_ID', 'rgba(61, 178, 208, 1)');
              </script>
            </head>
            
            <body>
              <div id="website-embed-div"></div>=
            </body>
            
            </html>
        """
    }
}