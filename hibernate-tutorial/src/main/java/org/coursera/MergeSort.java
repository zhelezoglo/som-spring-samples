package org.coursera;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    static int[] sort(int[] src) {
        if (src == null) return null;
        if (src.length == 0 || src.length == 1) return src;

        int[] a = new int[src.length / 2];
        int[] b = new int[src.length - src.length / 2];
        System.arraycopy(src, 0, a, 0, a.length);
        System.arraycopy(src, a.length, b, 0, b.length);

        a = sort(a); // sorting 1st(left) half of input array
        b = sort(b); // sorting 2nd(right) half of input array
        return merge(a, b);
    }

    static int[] merge(int[] a, int[] b) {
        int n = a.length + b.length;
        int[] c = new int[n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (i < a.length) {
                if (j < b.length) {
                    // a and b both have elements => copying lowest of both to c
                    if (a[i] < b[j]) {
                        c[k] = a[i++];
                    } else {
                        c[k] = b[j++];
                    }
                } else { // j > b.length
                    // no elements left in b => copying all from a to c
                    //for (; k < n && i < a.length; k++) {
                    c[k] = a[i++];
                    //}
                }
            } else if (j < b.length) {
                // no elements left in a => copying all from b to c
                //for (; k < n && j < b.length; k++) {
                c[k] = b[j++];
                //}
            }
        }
        return c;
    }


    static String[] modifyArray(String[] src) {
        src[0] = "m";
        return src;
    }

    static void checkArrays() {
        String[] original = {"o", "o", "o"};
        System.out.println("original = " + Arrays.toString(original));
        String[] returned = modifyArray(original);
        System.out.println("returned = " + Arrays.toString(returned));
    }

    static void testMerge() {
        int[] a = {2, 3, 11};
        int[] b = {1, 4, 6, 7, 8, 9, 10, 12};
        System.out.println("c = " + Arrays.toString(merge(a, b)));
    }

    static void testSort() {
        List<int[]> unsortedArrays = new ArrayList<int[]>();
        unsortedArrays.add(null);
        unsortedArrays.add(new int[]{});
        unsortedArrays.add(new int[]{10});
        unsortedArrays.add(new int[]{1, 2});
        unsortedArrays.add(new int[]{2, 1});
        unsortedArrays.add(new int[]{2, 1, 3});
        unsortedArrays.add(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        unsortedArrays.add(new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}); // odd unsorted
        unsortedArrays.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}); // even unsorted
        unsortedArrays.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}); // odd sorted
        unsortedArrays.add(new int[]{1, 2, 3, 4, 5, 3, 6, 6, 7, 8, 9}); // with duplicates
        unsortedArrays.add(new int[]{11, 2, 1, 6, 7, 6, 5, 4, 8, 2, 1});
        unsortedArrays.add(new int[]{5, 4, 6, 1, 2, 3});
        unsortedArrays.add(new int[]{1, 3, 5, 2, 4, 6});  // only split inversions
        for (int[] unsortedArray : unsortedArrays) {
            System.out.println("sorted = " + Arrays.toString(sort(unsortedArray)));
        }
    }

    public static void main(String[] args) {
//        testMerge();
        testSort();
    }
}
