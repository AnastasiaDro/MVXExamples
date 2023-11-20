package com.nestdev.mvxexamples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val model = Model()

    private val textLiveData = MutableLiveData<String?>("start value")
    val textData: LiveData<String?> = textLiveData

    private val resultLiveData = MutableLiveData<Boolean>(false)
    val resultData: LiveData<Boolean> = resultLiveData

    //второе поле, в котором отображаем результат
    //тогда нам понадобится 2 лайф даты. Одна - на одно поле, а вторая - на другое




    private var currentIndex = 0
    private var isFirstValue = true
    fun save(str: String) {
        model.save(str)
        if (isFirstValue) {
            textLiveData.value = str
            isFirstValue = false
        }
    }

    fun getPrevious() {
        if (currentIndex > 0) {
            currentIndex--
            textLiveData.value = (model.getAtIndex(currentIndex))
            resultLiveData.value = true
        } else {
            textLiveData.value = null
            resultLiveData.value = false
        }
    }

    fun getNext() {
        if (isFirstValue) {
            textLiveData.value = model.getAtIndex(0)
            resultLiveData.value = true
            isFirstValue = false
        }
        if (currentIndex < model.getDataSize()) {
            textLiveData.value = model.getAtIndex(currentIndex)
            resultLiveData.value = true
            currentIndex++
        }
        else
            resultLiveData.value = false
            textLiveData.value = null
        }
    }
