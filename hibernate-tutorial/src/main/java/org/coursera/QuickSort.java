package org.coursera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    static int total = 0;
    static int totalInside = 0;

    public static int[] sort(int[] src) {

        quickSort(src, 0, src.length - 1);
        return src;
    }

    static int min(int[] arr, int i, int j, int k) {
        int min = j;
        if (arr[i] < arr[min]) min = i;
        if (arr[k] < arr[min]) min = k;
        return min;
    }

    static int max(int[] arr, int i, int j, int k) {
        int max = j;
        if (arr[i] > arr[max]) max = i;
        if (arr[k] > arr[max]) max = k;
        return max;
    }

    static int avg(int[] arr, int i, int j, int k) {
        int min = min(arr, i, j, k);
        int max = max(arr, i, j, k);
        if (arr[min] == arr[i] || arr[i] == arr[max]) {
            if (arr[min] == arr[j] || arr[j] == arr[max]) {
                return k;
            }
            return j;
        }
        return i;
    }


    static int choosePivot(int[] arr, int l, int r) {
//        return l;
//        return r;
//        System.out.println("l = " + l);
//        System.out.println("r = " + r);
        if ((r - l + 1) % 2 == 1) {
            int median = l + (r - l + 1) / 2;
            return avg(arr, median, l, r);
        }
        int median = (r - l + 1) / 2 - 1 + l;
        return avg(arr, median, l, r);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (r - l + 1 < 2) {
            return;
        }
        if (r - l + 1 > 0) {
            total += r - l;
        }
        int pivotPosition = choosePivot(arr, l, r);
        int rightPivotPosition = partitionOverPivot(arr, pivotPosition, l, r);
        quickSort(arr, l, rightPivotPosition - 1);
        quickSort(arr, rightPivotPosition + 1, r);

    }

    static int partitionOverPivot(int[] arr, int pivotPosition, int l, int r) {
        if (pivotPosition != l) {
            swap(arr, pivotPosition, l);
        }
        int pivot = arr[l];
        int j = l + 1; // most right index of viewed(partitioned)
        int i = l + 1; // most left index of the stuff that is bigger than the pivot
        for (; j <= r; j++) {
            totalInside++;
            if (arr[j] < pivot) {
                swap(arr, i++, j);
            }
        }
        swap(arr, l, i - 1);
        return i - 1;
    }

    static void swap(int[] arr, int j, int k) {
        int tmp = arr[j];
        arr[j] = arr[k];
        arr[k] = tmp;
    }


    static void testSort() {
        List<int[]> unsortedArrays = new ArrayList<int[]>();
//        unsortedArrays.add(null);
//        unsortedArrays.add(new int[]{});
//        unsortedArrays.add(new int[]{10});
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
//        testSort();
        int[] ints = {3, 4, 5, 2, 1, 0};
        System.out.println("min(1,2,3) = " + min(ints, 2, 2, 5));
        System.out.println("max(1,2,3) = " + max(ints, 1, 2, 5));
        System.out.println("avg(1,2,3) = " + avg(ints, 0, 2, 5));
    }
}
