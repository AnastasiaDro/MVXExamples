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
    val model = Model()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.saveButton.setOnClickListener {
            val printedText = binding.editText.text.toString()
            model.save(printedText)
        }

        binding.showPreviousSavedTextButton.setOnClickListener {
            val result = model.showPrevious()
            if (result.isEmpty())
                Toast.makeText(this, "No texts before showed!", Toast.LENGTH_LONG).show()
            else binding.savedTextTextView.text = result
        }

        binding.showNextSavedTextButton.setOnClickListener {
            val result = model.showNext()
            if (result.isEmpty()) {
                Toast.makeText(this, "No texts after showed!", Toast.LENGTH_LONG).show()
            } else {
                binding.savedTextTextView.text = result
            }
        }
    }
}
