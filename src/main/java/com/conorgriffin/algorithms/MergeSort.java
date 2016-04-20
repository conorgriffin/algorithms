package com.conorgriffin.algorithms;

/**
 * Implementation of Merge Sort
 *
 * Divide and conquer by recursively dividing the array to be sorted in half and sorting the sub-arrays before merging
 * back together.
 */
class MergeSort {

    static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        System.arraycopy(a, 0, aux, 0, a.length);

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }

    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

}
