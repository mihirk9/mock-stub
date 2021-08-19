package com.example

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class AutoTellerMachineTest: StringSpec({
    "should print a receipt if money is withdrawn successfully" {
        // arrange
        val fakePrinter = mockk<Printer>()
        val fakeBankingService = mockk<BankingService>()
        val amount = 1000
        val atm = AutoTellerMachine(fakePrinter, fakeBankingService)
        every { fakePrinter.print(any()) } returns Unit
        every { fakeBankingService.withdraw(any()) } returns Unit

        // act
        atm.withdraw(amount)

        // assert
        verify { fakePrinter.print("$amount withdrawn") }
    }

    "should throw exception if banking service throws an exception" {
        // arrange
        val fakePrinter = mockk<Printer>()
        val fakeBankingService = mockk<BankingService>()
        val amount = 1000
        val atm = AutoTellerMachine(fakePrinter, fakeBankingService)
        every { fakePrinter.print(any()) } returns Unit
        every { fakeBankingService.withdraw(any()) } throws Exception()

        // act
        atm.withdraw(amount)

        // assert
        verify { fakePrinter.print("error withdrawing amount") }
    }
})