package com.conorgriffin.algorithms.sorting;

import java.util.Random;

/**
 * Implementation of Quick Sort
 * <p>
 * Shuffle the input array, then recursively partition and sort sub-arrays
 */
class QuickSort {

    public static <T extends Comparable<T>> void sort(T[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static <T extends Comparable<T>> void shuffle(T[] a) {
        int index;
        T temp;
        Random random = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo]))
                if (i == hi) break;
            while (less(a[lo], a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

}
