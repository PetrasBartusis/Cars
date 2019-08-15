package com.example.cars

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Make sure this is before calling super.onCreate
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showMessage(message: String) {
        Snackbar.make(container, message, Snackbar.LENGTH_LONG).show()
    }
}
