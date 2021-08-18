package com.example

import java.lang.Exception

class FakeBankingService(private val shouldTransactionSucceed: Boolean) : BankingService {
    override fun withdraw(amount: Int) {
        if (!shouldTransactionSucceed) throw Exception()
    }
}