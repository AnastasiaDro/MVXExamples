package com.nestdev.mvxexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nestdev.mvxexamples.databinding.ActivityMainBinding

/** Our screen **/
class MainActivity : AppCompatActivity(), IMain.IMainView {

    /** Just help to do not use find view by id **/
    private val binding: ActivityMainBinding by viewBinding()

    private val presenter: IMain.IMainPresenter = MainPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.saveButton.setOnClickListener {
            val printedText = binding.editText.text.toString()
            presenter.pressedSave(printedText)
        }

        binding.showPreviousSavedTextButton.setOnClickListener {
           presenter.pressedPrevious()
        }

        binding.showNextSavedTextButton.setOnClickListener {
           presenter.pressedNext()
        }

        binding.newButton.setOnClickListener {
            presenter.pressedNewButton()
        }
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
    override fun showText(text: String) {
        binding.savedTextTextView.text = text
    }
}
