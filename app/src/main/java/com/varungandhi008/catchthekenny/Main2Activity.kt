package com.varungandhi008.catchthekenny

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent =intent
        val received:String=intent.getStringExtra("score")
        textView.text="Your Score: "+received

        val sharedPreferences=this.getSharedPreferences("com.varungandhi008.catchthekenny", android.content.Context.MODE_PRIVATE)

        var highScore=sharedPreferences.getInt("highScore",0)
        if (highScore<received.toInt()) {
            highScore = received.toInt()
            sharedPreferences.edit().putInt("highScore", highScore).apply()
        }
        val storedHighScore=sharedPreferences.getInt("highScore",0)
        textView3.text="High Score: "+ storedHighScore
    }


    fun reset(view: View){
        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}
