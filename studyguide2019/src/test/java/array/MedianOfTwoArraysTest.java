package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedianOfTwoArraysTest {

    @Test
    public void test1() {
        int[] a = {1, 3};
        int[] b = {2};
        MedianOfTwoArrays md = new MedianOfTwoArrays();
        double res = md.findMedianSortedArrays(a,b);
        Assertions.assertEquals(2.0, res);
    }

    @Test
    public void test2() {
        int[] a = {1, 2};
        int[] b = {3, 4};
        MedianOfTwoArrays md = new MedianOfTwoArrays();
        double res = md.findMedianSortedArrays(a,b);
        Assertions.assertEquals(2.5, res);
    }

    @Test
    public void test3() {
        int[] a = {};
        int[] b = {2,3};
        MedianOfTwoArrays md = new MedianOfTwoArrays();
        double res = md.findMedianSortedArrays(a,b);
        Assertions.assertEquals(2.5, res);
    }

    @Test
    public void test4() {
        int[] a = {};
        int[] b = {2};
        MedianOfTwoArrays md = new MedianOfTwoArrays();
        double res = md.findMedianSortedArrays(a,b);
        Assertions.assertEquals(2, res);
    }

    @Test
    public void test5() {
        int[] a = {};
        int[] b = {};
        MedianOfTwoArrays md = new MedianOfTwoArrays();
        double res = md.findMedianSortedArrays(a,b);
        Assertions.assertEquals(0.0, res);
    }

    @Test
    public void test6() {
        int[] a = {0};
        int[] b = {1, 0};
        MedianOfTwoArrays md = new MedianOfTwoArrays();
        double res = md.findMedianSortedArrays(a,b);
        Assertions.assertEquals(1.0, res);
    }

    @Test
    public void test7() {
        int[] a = {0};
        int[] b = {0};
        MedianOfTwoArrays md = new MedianOfTwoArrays();
        double res = md.findMedianSortedArrays(a,b);
        Assertions.assertEquals(0.0, res);
    }
}
