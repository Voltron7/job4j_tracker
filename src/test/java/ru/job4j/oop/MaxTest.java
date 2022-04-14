package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void maxOfTwo() {
        int expected = 2;
        int first = 2;
        int second = 1;
        int out = Max.max(first, second);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void maxOfThree() {
        int expected = 3;
        int first = 2;
        int second = 1;
        int third = 3;
        int out = Max.max(first, second, third);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void maxOfFour() {
        int expected = 4;
        int first = 2;
        int second = 1;
        int third = 3;
        int fourth = 4;
        int out = Max.max(first, second, third, fourth);
        Assert.assertEquals(expected, out);
    }
}