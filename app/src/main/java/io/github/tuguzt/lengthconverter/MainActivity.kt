package io.github.tuguzt.lengthconverter

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kmEditText = findViewById<EditText>(R.id.km)
        val mEditText = findViewById<EditText>(R.id.m)
        val dmEditText = findViewById<EditText>(R.id.dm)
        val smEditText = findViewById<EditText>(R.id.sm)
        val mmEditText = findViewById<EditText>(R.id.mm)

        val inspectButton = findViewById<Button>(R.id.inspect)
        val resultTextView = findViewById<TextView>(R.id.result)
        val answerImageView = findViewById<ImageView>(R.id.answer)

        inspectButton.setOnClickListener {
            fun good() {
                val drawable = AppCompatResources.getDrawable(this, R.drawable.cool)
                answerImageView.setImageDrawable(drawable)

                resultTextView.text = getString(R.string.good)
                resultTextView.setTextColor(Color.BLUE)
            }

            fun bad() {
                val drawable = AppCompatResources.getDrawable(this, R.drawable.bad)
                answerImageView.setImageDrawable(drawable)

                resultTextView.text = getString(R.string.bad)
                resultTextView.setTextColor(Color.RED)
            }

            try {
                val km = kmEditText.text.toString().toDouble()
                val m = mEditText.text.toString().toDouble()
                val dm = dmEditText.text.toString().toDouble()
                val sm = smEditText.text.toString().toDouble()
                val mm = mmEditText.text.toString().toDouble()

                if (km * 1000 == m && m * 10 == dm && dm * 10 == sm && sm * 10 == mm) good()
                else bad()
            } catch (_: NumberFormatException) {
                bad()
            }
        }

        answerImageView.setOnClickListener {
            if (answerImageView.alpha < 0.1f) {
                answerImageView.alpha = 1f
                return@setOnClickListener
            }
            answerImageView.alpha -= 0.1f
        }
    }
}
