package com.nestdev.mvxexamples

interface MainEvent { }

class SaveEvent(val text: String): MainEvent

class AskPreviousTextEvent(): MainEvent

class AskNextTextEvent(): MainEvent