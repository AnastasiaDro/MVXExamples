package com.nestdev.mvxexamples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView.State
import java.util.Stack

class MainViewModel : ViewModel() {

    private val model = Model()

//    private val textLiveData = MutableLiveData<String?>("start value")
//    val textData: LiveData<String?> = textLiveData
//
//    private val resultLiveData = MutableLiveData<Boolean>(false)
//    val resultData: LiveData<Boolean> = resultLiveData
//

    private val stateLiveData = MutableLiveData<MainState>()
    val stateData: LiveData<MainState> = stateLiveData

    init {
        stateLiveData.value = MainState(text = "no text", result = false)
    }

    //второе поле, в котором отображаем результат
    //тогда нам понадобится 2 лайф даты. Одна - на одно поле, а вторая - на другое

    private var currentIndex = 0
    private var isFirstValue = true


    fun send(event: MainEvent) {
        when (event) {
            is SaveEvent -> save(event.text)
            is AskNextTextEvent -> getNext()
            is AskPreviousTextEvent -> getPrevious()
        }
    }

    private fun save(str: String) {
        model.save(str)
        if (isFirstValue) {
            stateLiveData.value = MainState(text = str, stateLiveData.value!!.result)
            isFirstValue = false
        }
    }

    private fun getPrevious() {
        if (currentIndex > 0) {
            currentIndex--
            stateLiveData.value = MainState(text = model.getAtIndex(currentIndex), result = true)
        } else {
            stateLiveData.value = stateLiveData.value!!.copy(result = false)
        }
    }

    private fun getNext() {
        if (isFirstValue) {
            stateLiveData.value = MainState(text = model.getAtIndex(0), true)
            isFirstValue = false
        }
        if (currentIndex < model.getDataSize()) {
            stateLiveData.value = MainState(text = model.getAtIndex(currentIndex), true)
            currentIndex++
        }
        else
            stateLiveData.value = stateLiveData.value!!.copy(result = false) //тоже создание нового объекта мейнстейт
        }
    }
