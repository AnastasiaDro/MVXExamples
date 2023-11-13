package com.nestdev.mvxexamples

import android.widget.Toast

class Model {

    /** data **/
    private val savedTextsArray = mutableListOf<String>()

    fun save(str:String) {
        if (str.isNotEmpty())
            savedTextsArray.add(str)
    }

    fun getAtIndex(index: Int): String {
        return savedTextsArray.get(index)
    }

    fun getDataSize(): Int {
        return savedTextsArray.size
    }
}