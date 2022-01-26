package com.basicNavTest.utilities;

public class StringUtility {

    public static void verifyEquals(String expected, String actual){
        System.out.println("Expected value is : " + expected);
        System.out.println("Actual value is : " + actual);

        if (expected.equals(actual)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
