package com.example.slots

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.example.slots.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scoretextView2.text =getSharedPreferences("settings", Context.MODE_PRIVATE)
            .getInt("diamond", 1000).toString()


    }

    override fun onResume() {
        super.onResume()
        binding.scoretextView2.text =getSharedPreferences("settings", Context.MODE_PRIVATE)
            .getInt("diamond", 1000).toString()
    }
    fun start(view: View){
        var intent = Intent(this@MainActivity,GameActivity::class.java)
        startActivity(intent)
    }

    fun openPolitics(view: View){
        val url = "https://www.google.com/"
        val customTabsIntent: CustomTabsIntent = CustomTabsIntent.Builder().setColorScheme(
            CustomTabsIntent.COLOR_SCHEME_DARK).build()
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}