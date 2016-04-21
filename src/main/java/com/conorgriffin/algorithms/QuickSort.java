package com.conorgriffin.algorithms;

import java.util.Random;

/**
 * An implementation of Quick Sort
 */
class QuickSort {

    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length -1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static void shuffle(Comparable[] a) {
        int index;
        Comparable temp;
        Random random = new Random();
        for (int i = a.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        while (true) {
            while(less(a[++i], a[lo]))
                if (i == hi) break;
            while(less(a[lo], a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

}
