package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AutoTellerMachineTest: StringSpec({
    "should print a receipt if money is withdrawn successfully" {
        // arrange
        val fakePrinter = FakePrinter()
        val amount = 1000
        val atm = AutoTellerMachine(fakePrinter, FakeBankingService(true))

        // act
        atm.withdraw(amount)

        // assert
        val expectedOutput = "$amount withdrawn"
        fakePrinter.printerInvokeCount() shouldBe 1
        fakePrinter.lastReceipt() shouldBe expectedOutput
    }

    "should throw exception if banking service throws an exception" {
        // arrange
        val fakePrinter = FakePrinter()
        val fakeBankingService = FakeBankingService(false)
        val amount = 1000
        val atm = AutoTellerMachine(fakePrinter, fakeBankingService)

        // act
        atm.withdraw(amount)

        // assert
        val expectedOutput = "error withdrawing amount"
        fakePrinter.printerInvokeCount() shouldBe 1
        fakePrinter.lastReceipt() shouldBe expectedOutput
    }
})