package org.junit.assignment.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void addTest(){

        int addactualOuput = Calculator.add(2, 2);
        int addexpectedOutput = 4;
        Assertions.assertEquals(addactualOuput, addexpectedOutput, "Test failed  addition");
    }

    @Test
    public  void subTest(){
        int minusactualOuput = Calculator.minus(2, 2);
        int minusexpectedOutput = 0;
        Assertions.assertEquals(minusactualOuput, minusexpectedOutput, "Test failed substraction ");
    }

    @Test
    public void mulTest(){
        int mulactualOuput = Calculator.multiply(10, 15);
        int mulexpectedOutput = 150;
        Assertions.assertEquals(mulactualOuput, mulexpectedOutput, "Test failed muiltipliaction");
    }

    @Test
    public  void divTest(){
        int divactualOuput = Calculator.divide(10, 5);
        int divexpectedOutput = 2;
        Assertions.assertEquals(divactualOuput, divexpectedOutput, "Test failed dividsion");
    }

}
