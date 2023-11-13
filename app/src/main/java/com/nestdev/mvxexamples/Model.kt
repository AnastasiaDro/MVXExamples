package com.nestdev.mvxexamples

import android.widget.Toast

class Model {

    /** data **/
    private val savedTextsArray = mutableListOf<String>()

    /** logic **/
    private var currentIndex = 0
    private var isFirstValue = true

    fun save(str:String) {
        if (str.isNotEmpty())
            savedTextsArray.add(str)
    }

    fun showPrevious(): String {
        if (currentIndex > 0) {
            currentIndex--
            return savedTextsArray[currentIndex]
        } else {
           return ""
        }
    }

    fun showNext(): String {
        var result = ""
        if (isFirstValue) {
            result = savedTextsArray[0]
            isFirstValue = false
        }
        if (currentIndex < savedTextsArray.lastIndex) {
            currentIndex++
            result = savedTextsArray[currentIndex]
        }
        return result
    }

}