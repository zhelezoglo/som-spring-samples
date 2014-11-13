package com.som.stuff;

/**
 * @author som
 */
public class BinarySearch {
    static int[] array = {1, 3, 6, 8, 10};

    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        for (; low <= high; ) {
            int cur = low + (high - low) / 2;
            if (a[cur] == key) {
                return cur;
            } else if (a[cur] < key) {
                low = cur + 1;
            } else {
                high = cur;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(array, 8));
    }

}
