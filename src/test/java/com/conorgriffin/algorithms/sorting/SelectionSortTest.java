package com.conorgriffin.algorithms.sorting;

import java.util.Random;

import static org.junit.Assert.*;

public class SelectionSortTest {
    @org.junit.Test
    public void sort() throws Exception {
        Comparable[] a = new Comparable[]{3, 4, 6, 2, 1, 10, 9, 8, 7, 5};
        Comparable[] expected = new Comparable[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SelectionSort.sort(a);
        assertArrayEquals(expected, a);
    }

    @org.junit.Test
    public void bigSort() {
        Comparable[] a = new Comparable[100000];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(Integer.MAX_VALUE);
        }
        SelectionSort.sort(a);
        for (int i = 1; i < a.length; i++) {
            assertTrue((Integer) a[i] >= (Integer) a[i - 1]);
        }
    }

}