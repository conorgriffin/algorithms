package com.conorgriffin.algorithms.sorting;

/**
 * Implementation of Selection Sort
 * <p>
 * Starting with the first item, loop through all subsequent items to find the location of the smallest item to it's
 * right and swap or skip if no item to the right is smaller.  Repeat until all items have been processed
 */
class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exchange(a, i, min);
        }
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
