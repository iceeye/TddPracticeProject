package com.kay.tdd.fb;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * FizzBuzz第一次练习
 *
 * 需求如下：
 * 1.打印出从1到100的数字，
 * 2.将其中3的倍数替换成“Fizz”，
 * 3.5的倍数替换成“Buzz”，
 * 4.既能被3整除、又能被5整除的数则替换成“FizzBuzz”。
 */
public class FizzBuzzTest {

    @Test
    public void should_show_normal_number(){
        checkFizzBuzzNumber(1, "1");
        checkFizzBuzzNumber(2, "2");
    }

    @Test
    public void should_show_fizz_number() {
        checkFizzBuzzNumber(3, "fizz");
    }

    @Test
    public void should_show_buzz_number() {
        checkFizzBuzzNumber(5, "buzz");
    }

    @Test
    public void should_show_fizzbuzz_number() {
        checkFizzBuzzNumber(15, "fizzbuzz");
    }

    @Test
    public void should_show_fizz_number_contains_3(){
        checkFizzBuzzNumber(13, "fizz");
    }

    @Test
    public void should_show_buzz_number_contains_5(){
        checkFizzBuzzNumber(52, "buzz");
    }

    @Test
    public void should_show_fizzbuzz_number_contains_3_and_5(){
        checkFizzBuzzNumber(53, "fizzbuzz");
        checkFizzBuzzNumber(51, "fizzbuzz");
    }

    private void checkFizzBuzzNumber(int i, String s) {
        Assert.assertThat(new FizzBuzz(i).toString(), is(s));
    }
}
