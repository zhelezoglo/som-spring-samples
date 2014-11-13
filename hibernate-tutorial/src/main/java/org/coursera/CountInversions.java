package org.coursera;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SortAndCalcRecord {
    int[] sortedArray;
    long inversions;

    SortAndCalcRecord(int[] sortedArray, long inversions) {
        this.sortedArray = sortedArray;
        this.inversions = inversions;
    }
}


public class CountInversions {

    static int[] readIntArrayFromFile() throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("myfile.txt"));
        BufferedReader br = new BufferedReader(new FileReader("IntegerArray (1).txt"));
        List<Integer> numbers = new ArrayList<Integer>();
        String line;
        int[] ints = new int[100000];
//        int [] ints = new int[6];
        int i = 0;
        while ((line = br.readLine()) != null) {
            ints[i++] = Integer.parseInt(line);
        }
        System.out.println("i = " + i);
        br.close();
        return ints;
    }

    static long countInv(int[] src) {
        if (src == null) return -1;
        if (src.length == 0 || src.length == 1) return 0;

        int[] a = new int[src.length / 2];
        int[] b = new int[src.length - src.length / 2];
        System.arraycopy(src, 0, a, 0, a.length);
        System.arraycopy(src, a.length, b, 0, b.length);

        long x = countInv(a); // sorting 1st(left) half of input array
        long y = countInv(b); // sorting 2nd(right) half of input array
        long z = countSplitInv(a, b);
        return x + y + z;
    }

    private static long countSplitInv(int[] a, int[] b) {
        int n = a.length + b.length;
        int i = 0;
        int j = 0;
        long result = 0L;
        for (int k = 0; k < n; k++) {
            if (i < a.length) {
                if (j < b.length) {
                    // a and b both have elements => copying lowest of both to c
                    if (a[i] < b[j]) {
                        i++;
                    } else {
                        j++;
                        result += a.length - i;
                    }
                } else { // j > b.length
                    // no elements left in b => copying all from a to c
                    //for (; k < n && i < a.length; k++) {
                    i++;
                    //}
                }
            } else if (j < b.length) {
                // no elements left in a => copying all from b to c
                //for (; k < n && j < b.length; k++) {
                j++;
                result += a.length - i;
                //}
            }
        }
        return result;

    }

//===================================================================================================

    static SortAndCalcRecord sortAndCountInv(int[] src) {
        if (src == null) return null;
        if (src.length == 0 || src.length == 1) return new SortAndCalcRecord(src, 0);

        int[] a = new int[src.length / 2];
        int[] b = new int[src.length - src.length / 2];
        System.arraycopy(src, 0, a, 0, a.length);
        System.arraycopy(src, a.length, b, 0, b.length);

        SortAndCalcRecord leftHalf = sortAndCountInv(a); // sorting 1st(left) half of input array
        SortAndCalcRecord rightHalf = sortAndCountInv(b); // sorting 2nd(right) half of input array
        SortAndCalcRecord bothHalves = mergeAndCountSplitInv(leftHalf.sortedArray, rightHalf.sortedArray);
        return new SortAndCalcRecord(bothHalves.sortedArray,
                leftHalf.inversions + rightHalf.inversions + bothHalves.inversions);
    }

    private static SortAndCalcRecord mergeAndCountSplitInv(int[] a, int[] b) {
        int n = a.length + b.length;
        int[] c = new int[n];
        int i = 0;
        int j = 0;
        long result = 0;
        for (int k = 0; k < n; k++) {
            if (i < a.length) {
                if (j < b.length) {
                    // a and b both have elements => copying lowest of both to c
                    if (a[i] < b[j]) {
                        c[k] = a[i++];
                    } else {
                        c[k] = b[j++];
                        result += a.length - i;
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
                result += a.length - i;
                //}
            }
        }
        return new SortAndCalcRecord(c, result);

    }

//==================================================================================================================

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

    static void testSortAndCountInversions() {
        List<int[]> unsortedArrays = new ArrayList<int[]>();
//        unsortedArrays.add(null);
        unsortedArrays.add(new int[]{});
        unsortedArrays.add(new int[]{10});
        unsortedArrays.add(new int[]{1, 2});
        unsortedArrays.add(new int[]{2, 1});
        unsortedArrays.add(new int[]{2, 1, 3});
        unsortedArrays.add(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        unsortedArrays.add(new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}); // odd unsorted
        unsortedArrays.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}); // even unsorted
        unsortedArrays.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}); // odd sorted
//        unsortedArrays.add(new int[]{1, 2, 3, 4, 5, 3, 6, 6, 7, 8, 9}); // with duplicates
//        unsortedArrays.add(new int[]{11, 2, 1, 6, 7, 6, 5, 4, 8, 2, 1});
        unsortedArrays.add(new int[]{5, 4, 6, 1, 2, 3});
        unsortedArrays.add(new int[]{1, 3, 5, 2, 4, 6});  // only split inversions
        unsortedArrays.add(new int[]{2, 3, 1, 6, 5, 4});  // only split inversions
        for (int[] unsortedArray : unsortedArrays) {
            System.out.println("unsorted = " + Arrays.toString(unsortedArray));
            SortAndCalcRecord sortAndCalcRecord = sortAndCountInv(unsortedArray);
//            System.out.println("sorted = " + Arrays.toString(sortAndCalcRecord.sortedArray));
            System.out.println("inversions = " + sortAndCalcRecord.inversions);
            System.out.println("==========================================================================");
        }
    }

    static void testCountInversions() {
        List<int[]> unsortedArrays = new ArrayList<int[]>();
//        unsortedArrays.add(null);
        unsortedArrays.add(new int[]{});
        unsortedArrays.add(new int[]{10});
        unsortedArrays.add(new int[]{1, 2});
        unsortedArrays.add(new int[]{2, 1});
        unsortedArrays.add(new int[]{2, 1, 3});
        unsortedArrays.add(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        unsortedArrays.add(new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}); // odd unsorted
        unsortedArrays.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}); // even unsorted
        unsortedArrays.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}); // odd sorted
//        unsortedArrays.add(new int[]{1, 2, 3, 4, 5, 3, 6, 6, 7, 8, 9}); // with duplicates
//        unsortedArrays.add(new int[]{11, 2, 1, 6, 7, 6, 5, 4, 8, 2, 1});
        unsortedArrays.add(new int[]{5, 4, 6, 1, 2, 3});
        unsortedArrays.add(new int[]{1, 3, 5, 2, 4, 6});  // only split inversions
        for (int[] unsortedArray : unsortedArrays) {
            System.out.println("unsorted = " + Arrays.toString(unsortedArray));
            System.out.println("inversions = " + countInv(unsortedArray));
            System.out.println("==========================================================================");
        }
    }


    public static void main(String[] args) throws IOException {
//        testMerge();
//        testSort();
        testSortAndCountInversions();
        //testCountInversions();
//        System.out.println(Arrays.toString(readIntArrayFromFile()));
//        System.out.println(countInv(readIntArrayFromFile()));
    }

}
