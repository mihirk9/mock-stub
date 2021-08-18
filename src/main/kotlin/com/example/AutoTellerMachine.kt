package com.example

class AutoTellerMachine(
    private val fakePrinter: Printer,
    private val bankingService: BankingService
) {
    fun withdraw(amount: Int) {
        try {
            bankingService.withdraw(amount)
            fakePrinter.print("$amount withdrawn")
        } catch (e: Exception) {
            fakePrinter.print("error withdrawing amount")
        }
    }
}