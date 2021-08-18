package com.example

class FakePrinter: Printer {
    private var numInvoked = 0
    private var lastReceipt = ""

    fun printerInvokeCount() = numInvoked

    fun lastReceipt() = lastReceipt

    override fun print(text: String) {
        numInvoked++
        lastReceipt = text
    }
}