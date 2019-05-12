package com.varungandhi008.catchthekenny
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var score: Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler: Handler = Handler()
    var runnable: Runnable = Runnable { }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = 0

        imageArray = arrayListOf(
            imageView1,
            imageView2,
            imageView3,
            imageView4,
            imageView5,
            imageView6,
            imageView7,
            imageView8,
            imageView9
        )

        hideImages()

        object : CountDownTimer(11000, 1000) {
            override fun onFinish() {
                textView1.text = "Time is Over"
                handler.removeCallbacks(runnable)
               // for (image in imageArray)
             //       image.visibility = View.INVISIBLE

                val intent = Intent(applicationContext,Main2Activity::class.java)
                intent.putExtra("score",score.toString())
                startActivity(intent)
                finish()
            }

            override fun onTick(p0: Long) {
                textView1.text = "Time Left :" + p0 / 1000
            }

        }.start()

    }

    fun hideImages() {

        runnable = object : Runnable {
            override fun run() {

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val index = random.nextInt(8 - 0)
                imageArray[index].visibility = View.VISIBLE

                handler.postDelayed(runnable, 500)

            }

        }

        handler.post(runnable)

    }


    fun press(view: View) {
        ++score
        textView2.text = "Score :" + score
    }




}
