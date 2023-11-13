package com.nestdev.mvxexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nestdev.mvxexamples.databinding.ActivityMainBinding

/** Our screen **/
class MainActivity : AppCompatActivity() {

    /** Just help to do not use find view by id **/
    private val binding: ActivityMainBinding by viewBinding()

    private val savedTextsArray = mutableListOf<String>()
    private var currentIndex = 0
    private var isFirstValue = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.saveButton.setOnClickListener {
            val printedText = binding.editText.text.toString()
            savedTextsArray.add(printedText)
        }

        binding.showPreviousSavedTextButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                binding.savedTextTextView.text = savedTextsArray[currentIndex]
            } else {
                Toast.makeText(this, "No texts before showed!", Toast.LENGTH_LONG).show()
            }
        }

        binding.showNextSavedTextButton.setOnClickListener {
            if (isFirstValue) {
                binding.savedTextTextView.text = savedTextsArray[0]
                isFirstValue = false
            }
            if (currentIndex < savedTextsArray.lastIndex) {
                currentIndex++
                binding.savedTextTextView.text = savedTextsArray[currentIndex]
            } else {
                Toast.makeText(this, "No texts after showed!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
