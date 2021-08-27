/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girish.tddtest;

import org.junit.Assert;
import org.junit.Test;
import com.girish.tddtest.tdd.StringCalculator;

public class GirishStringCalculatorTest {
     @Test(expected = RuntimeException.class)
    public final void ThenExceptionIsThrown() {
        StringCalculator.add("1,2,3");
    } 
    @Test
    public final void ThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
        Assert.assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void UsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }
    @Test
    public final void UsedThenReturnValueIs0() {
    Assert.assertEquals(0, StringCalculator.add1(""));
    }
    @Test
    public final void UsedThenReturnValueIsThatSameNumber() {
    Assert.assertEquals(3, StringCalculator.add2("3"));
    }
    @Test
    public final void UsedThenReturnValueIsTheirSum() {
    Assert.assertEquals(3+6, StringCalculator.add2("3,6"));
    }
    @Test
    public final void UsedThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15+18+46+33, StringCalculator.add3("3,6,15,18,46,33"));
    }
    @Test
    public final void BetweenNumbersThenReturnValuesAreTheirSums() {
    Assert.assertEquals(3+6+15, StringCalculator.add4("3,6n15"));
    }
    @Test
    public final void UsedToSeparateNumbers() {
    Assert.assertEquals(3+6+15, StringCalculator.add5("//;n3;6;15"));
    }
    @Test(expected = RuntimeException.class)
    public final void NegativeNumberIsUsed() {
    StringCalculator.add("3,-6,15,18,46,33");
    }
    @Test
    public final void NegativeNumbersAreUsedThenRuntimeException() {
    RuntimeException exception = null;
    try {
        StringCalculator.add("3,-6,15,-18,46,33");
    } catch (RuntimeException e) {
        exception = e;
    }
    Assert.assertNotNull(exception);
    Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
    }
    @Test
    public final void UsedNotIncludedInSum() {
    Assert.assertEquals(3+1000+6, StringCalculator.add1("3,1000,1001,6,1234"));
}
}
