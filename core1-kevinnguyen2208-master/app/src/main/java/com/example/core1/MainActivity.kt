package com.example.core1

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val KEY_TEXT_VALUE = "innit"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sneeze = findViewById<Button>(R.id.sneeze)
        val alarm = findViewById<Button>(R.id.alarm)
        val take = findViewById<Button>(R.id.take)

        sneeze.setOnClickListener(onClickListener);
        alarm.setOnClickListener(onClickListener);
        take.setOnClickListener(onClickListener);

        if (savedInstanceState != null) {
            innit.text = savedInstanceState.getString("innit")
            var savedText = innit.text.toString().toInt()
            when (savedText){
                in 0..5 ->{
                    innit.setTextColor(Color.RED)
                }
                in 6..7 ->{
                    innit.setTextColor(Color.BLUE)
                }
                in 8..10 ->{
                    innit.setTextColor(Color.BLACK)
                }
            }
            Log.i("LIFECYCLE", "onSaveInstanceState")
        }
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState);
        outState.putString("innit",innit.text.toString())

    }

    override fun onStart(){
        super.onStart()
        Log.i("LIFECYCLE", "started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFECYCLE", "resumed")
    }


    override fun onPause(){
        super.onPause()
        Log.i("LIFECYCLE", "paused")
    }

    override fun onStop(){
        super.onStop()
        Log.i("LIFECYCLE", "stopped")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("LIFECYCLE", "destroyed")
    }


    private val onClickListener: View.OnClickListener = View.OnClickListener {

        sneeze.setOnClickListener { _ ->
            when(innit.text.toString().toInt()){
                in 1..5 -> {
                    val result = sneezeminus(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.RED)
                }
                6 -> {
                    val result = sneezeminus(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.RED)
                }
                in 7..8 -> {
                    val result = sneezeminus(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.BLUE)
                }
                in 9..10 -> {
                    val result = sneezeminus(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.BLACK)
                }
            }
        }

        alarm.setOnClickListener { _ ->
            val alarm = MediaPlayer.create(this, R.raw.alarm_clock);
            alarm.start()
        }

        take.setOnClickListener { _ ->
            when(innit.text.toString().toInt()){
                in 0..3 -> {
                    val result = takeadd(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.RED)
                }
                in 4..5 -> {
                    val result = takeadd(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.BLUE)
                }
                in 6..8 -> {
                    val result = takeadd(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.BLACK)
                }
                9 -> {
                    val result = take1(innit.text.toString())
                    innit.text = result.toString()
                    innit.setTextColor(Color.BLACK)
                }
            }
        }
    }
}


private fun sneezeminus(innit: String) = innit.toInt() - 1
private fun takeadd(innit: String) = innit.toInt() + 2
private fun take1(innit: String) = innit.toInt() + 1
