package com.example.avaliacao2githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avaliacao2githubapi.view.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
    }
}