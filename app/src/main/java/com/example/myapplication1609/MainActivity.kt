package com.example.myapplication1609

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val pressedButtons = mutableListOf<String>()
    val textView by lazy { findViewById<TextView>(R.id.output) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttons = listOf<Button>(
            findViewById<Button>(R.id.firstNum),
            findViewById<Button>(R.id.secondNum),
            findViewById<Button>(R.id.threeNum),
            findViewById<Button>(R.id.fourNum),
            findViewById<Button>(R.id.fiveNum),
            findViewById<Button>(R.id.sixNum),
            findViewById<Button>(R.id.sevenNum),
            findViewById<Button>(R.id.eightNum),
            findViewById<Button>(R.id.nineNum),
            findViewById<Button>(R.id.comma),
            findViewById<Button>(R.id.zero),
            findViewById<Button>(R.id.ravno),
            findViewById<Button>(R.id.plus),
            findViewById<Button>(R.id.minus),
            findViewById<Button>(R.id.multiply),
            findViewById<Button>(R.id.sub),
            findViewById<Button>(R.id.deleteAll),
            findViewById<Button>(R.id.delit)
        )

        buttons.forEach {
            it.setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) {

        val button = view as? Button
        when (button?.id) {
            R.id.ravno -> {
                solve(pressedButtons)
                return
            }
            else -> pressedButtons.add(button?.text.toString())

        }
        textView.text = pressedButtons.joinToString(separator = "")
    }

    fun solve(pressedButtons: List<String>) {
        val actions = listOf('+', '-', '/', '*')
        val equality = pressedButtons.joinToString(separator = "")
        val indexOfAction = equality.indexOfAny(actions.toCharArray())
        val actionSign = equality[indexOfAction]
        val first = equality.substring(0 until indexOfAction).toInt()
        val second = equality.substring(indexOfAction + 1 until equality.length).toInt()
        val valume = when (actionSign) {
            '+' -> first + second
            '-' -> first - second
            '/' -> first / second
            '*' -> first * second
            else -> "Отдых"
        }
        textView.text = valume.toString()
    }

}




