package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun backSpaceAction(view: View) {}
    fun allClearAction(view: View) {}
    fun equalsAction(view: View) {}
    fun operationAction(view: View) {}
    fun numberAction(view: View) {}
}