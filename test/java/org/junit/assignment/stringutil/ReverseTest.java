package org.junit.assignment.stringutil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseTest {
    @Test
    public void reverseTest(){
        String original=Reverse.reverse("java");
        String expected="avaj";
        Assertions.assertEquals(expected,original,"Test Failed reverse");
    }

    @Test
    public void isPalindromeTest(){
        boolean result=Reverse.isPalidrome("aba");
        Assertions.assertTrue(result,"Test Failed :isPalindrome");
    }

    @Test
    public void toUpperCaseTest(){
        String result=Reverse.toUpperCase("java");
        Assertions.assertEquals("JAVA",result,"Test Failed :toUpperCase");

    }
}
