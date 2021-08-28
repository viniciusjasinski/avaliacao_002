package com.example.avaliacao2githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avaliacao2githubapi.view.AllRepositoriesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AllRepositoriesFragment.newInstance())
                .commitNow()
    }
}