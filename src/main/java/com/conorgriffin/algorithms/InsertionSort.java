package com.conorgriffin.algorithms;

/**
 * Implementation of Insertion Sort
 *
 * Starting with the first item, check each preceding item to see if it's larger.  If it is, exchange the current item
 * with the previous item and repeat until either it's in the first position or the previous item is smaller (or equal)
 */
class InsertionSort {

    static void sort(Comparable[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    exchange(a, j, j - 1);
                else break;
            }
        }
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
