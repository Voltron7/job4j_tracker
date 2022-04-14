package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when00to20then2() {
        int expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when00to20to00then2() {
        int expected = 2;
        Point c = new Point(0, 0, 0);
        Point d = new Point(0, 2, 0);
        double dist3d = c.distance3d(d);
        Assert.assertEquals(expected, dist3d, 0.01);
    }

    @Test
    public void when00to30then3() {
        double expected = 3;
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when00to30to00then3() {
        int expected = 3;
        Point c = new Point(0, 0, 0);
        Point d = new Point(0, 3, 0);
        double dist3d = c.distance3d(d);
        Assert.assertEquals(expected, dist3d, 0.01);
    }

        @Test
        public void when00to40then4() {
        double expected = 4;
        Point a = new Point(0, 0);
        Point b = new Point(0, 4);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when00to40to00then4() {
        int expected = 4;
        Point c = new Point(0, 0, 0);
        Point d = new Point(0, 4, 0);
        double dist3d = c.distance3d(d);
        Assert.assertEquals(expected, dist3d, 0.01);
    }
}