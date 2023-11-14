package com.nestdev.mvxexamples

class MainPresenterImpl(private val view: IMain.IMainView): IMain.IMainPresenter {

    private val model = Model()

    private var currentIndex = 0
    private var isFirstValue = true

    override fun pressedSave(str: String) {
        model.save(str)
    }

    override fun pressedPrevious() {
        if (currentIndex > 0) {
            currentIndex--
            view.showText(model.getAtIndex(currentIndex))
        } else {
            view.showToast("No previous")
        }
    }

    override fun pressedNewButton() {
        view.showText("BLABLABLA")
    }

    override fun pressedNext() {
        if (isFirstValue) {
            view.showText(model.getAtIndex(0))
            isFirstValue = false
        }
        if (currentIndex < model.getDataSize()) {
            currentIndex++
            view.showText(model.getAtIndex(currentIndex))
        }
        else
            view.showToast("No next")
    }
}