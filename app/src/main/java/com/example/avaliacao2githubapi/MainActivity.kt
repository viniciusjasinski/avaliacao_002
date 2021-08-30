package com.example.avaliacao2githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.avaliacao2githubapi.view.AllRepositoriesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        changeFragments(AllRepositoriesFragment.newInstance())
    }

    fun changeFragments(fragment: Fragment) {
        setContentView(R.layout.main_activity)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
    }
}