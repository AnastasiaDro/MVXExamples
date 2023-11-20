package com.nestdev.mvxexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nestdev.mvxexamples.databinding.ActivityMainBinding

/** Our screen **/
class MainActivity : AppCompatActivity() {

    /** Just help to do not use find view by id **/
    private val binding: ActivityMainBinding by viewBinding()

    private val viewModel: MainViewModel by viewModels()

    //Если нужно что-то передать в конструктор, то использовать ViewModelProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.textData.observe(this) { text ->
            if (text == null) showToast("No Value")
            else
                showText(text)
        }
        viewModel.resultData.observe(this) { result ->
            binding.resultTextView.text = result.toString()
        }

        binding.saveButton.setOnClickListener {
            val printedText = binding.editText.text.toString()
            viewModel.save(printedText)
        }

        binding.showPreviousSavedTextButton.setOnClickListener {
           viewModel.getPrevious()
        }

        binding.showNextSavedTextButton.setOnClickListener {
           viewModel.getNext()
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
    private fun showText(text: String) {
        binding.savedTextTextView.text = text
    }
}
