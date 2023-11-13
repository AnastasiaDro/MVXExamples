package com.nestdev.mvxexamples

interface IMain {

    interface IMainPresenter {
        fun pressedSave(str: String)
        fun pressedPrevious()
        fun pressedNext()
        fun pressedNewButton()
    }

    interface IMainView {
        fun showToast(text: String)
        fun showText(text: String)
    }
}

