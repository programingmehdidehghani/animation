package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var seekBar: SeekBar
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.textView_progress)
        seekBar=findViewById(R.id.seekbar)
        button=findViewById(R.id.button)
        val txtintin=textView.translationY
        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = progress.toString()

                val translation=(txtintin + progress * resources.getDimension(R.dimen.text_anim_step) * -1)
                textView.animate().translationY(translation)
                if (!fromUser)
                     textView.animate().setDuration(500).rotationYBy(360f)
                    .translationY(txtintin)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }


            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        button.setOnClickListener(View.OnClickListener {
            seekBar.progress=0

        })


    }
}