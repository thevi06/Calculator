package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var canAddOperation = false
    private var canAddDecimal = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun backSpaceAction(view: View)
    {
        val length = workingsTV.length()
        if (length > 0)
            workingsTV.text = workingsTV.text.subSequence(0, length - 1)
    }
    fun allClearAction(view: View)
    {
        workingsTV.text = ""
        resultsTV.text = ""
    }

    fun equalsAction(view: View)
    {
        resultsTV.text = calculateResults()
    }

    private fun calculateResults(): String
    {
        return ""
    }

    private fun digitsOperators():MutableList<Any>
    {
        val list = mutableListOf<Any>()
        var currentDigit = ""
        for(character in workingsTV.text)
        {
            if(character.isDigit() || character == '.')
                currentDigit += character
            else
            {
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(character)
            }
        }

        return list
    }

    fun operationAction(view: View)
    {
        if(view is Button && canAddOperation)
        {
            workingsTV.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }
    fun numberAction(view: View)
    {
        if(view is Button)
        {
            if(view.text == ".")
            {
                if(canAddDecimal)
                    workingsTV.append(view.text)
                canAddDecimal = false
            }
            else
                workingsTV.append(view.text)
            canAddOperation = true
        }
    }
}