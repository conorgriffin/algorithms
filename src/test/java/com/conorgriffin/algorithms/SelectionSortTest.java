package com.conorgriffin.algorithms;

import static org.junit.Assert.*;

/**
 * Created by conorgriffin on 19/04/2016.
 */
public class SelectionSortTest {
    @org.junit.Test
    public void sort() throws Exception {
        Comparable[] a = new Comparable[]{3, 4, 6, 2, 1, 10, 9, 8, 7, 5};
        Comparable[] expected = new Comparable[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SelectionSort.sort(a);
        assertArrayEquals(expected, a);
    }
}