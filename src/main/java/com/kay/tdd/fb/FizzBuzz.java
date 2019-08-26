package com.kay.tdd.fb;

import static java.lang.String.valueOf;

public class FizzBuzz {

    private int number;

    public FizzBuzz(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        String result = fizz() + buzz();

        return result.length() == 0 ? valueOf(number) : result;
    }

    private String fizz() {
        return getRemaindInfo(3, "fizz");
    }

    private String buzz() {
        return getRemaindInfo(5, "buzz");
    }

    private String getRemaindInfo(int factor, String info) {
        String factorStr = valueOf(factor);
        if (number % factor == 0 || valueOf(number).contains(factorStr)) {
            return info;
        }

        return "";
    }
}
