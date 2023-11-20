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

        viewModel.stateData.observe(this) { state ->
            binding.resultTextView.text = state.result.toString()
            binding.savedTextTextView.text = state.text

            if (!state.result)
                showToast("No value!")
        }

        binding.saveButton.setOnClickListener {
            val printedText = binding.editText.text.toString()
            viewModel.send(SaveEvent(printedText))
        }

        binding.showPreviousSavedTextButton.setOnClickListener {
           viewModel.send(AskPreviousTextEvent())
        }

        binding.showNextSavedTextButton.setOnClickListener {
           viewModel.send(AskNextTextEvent())
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
