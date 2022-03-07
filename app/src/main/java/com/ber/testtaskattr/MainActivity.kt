package com.ber.testtaskattr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }
    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, MainFragment())
            .commit()
    }

    override fun onButtonClicked() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, PhotoListFragment())
            .addToBackStack(null)
            .commit()
    }
}