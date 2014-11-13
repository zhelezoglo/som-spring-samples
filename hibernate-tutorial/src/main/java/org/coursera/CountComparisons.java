package org.coursera;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountComparisons {


    static int[] readIntArrayFromFile() throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("myfile.txt"));
//        BufferedReader br = new BufferedReader(new FileReader("IntegerArray (1).txt"));
        BufferedReader br = new BufferedReader(new FileReader("QuickSort.txt"));
        List<Integer> numbers = new ArrayList<Integer>();
        String line;
        int[] ints = new int[10000];
        int i = 0;
        while ((line = br.readLine()) != null) {
            ints[i++] = Integer.parseInt(line);
        }
        System.out.println("i = " + i);
        br.close();
        return ints;
    }

    public static void main(String[] args) throws IOException {
        int[] a = CountComparisons.readIntArrayFromFile();
//        int N = a.length;
//        Integer[] b = new Integer[N];
//        int[] c = new int[N];
//        for (int i = 0; i < N; i++)                 {
//            b[i] = a[i];
//            c[i] = a[i];
//        }

        System.out.println("" + Arrays.toString(a));
        System.out.println("" + Arrays.toString(QuickSort.sort(a)));
        System.out.println("TOTAL: " + QuickSort.total);
        System.out.println("TOTAL_INSIDE: " + QuickSort.totalInside);


    }


}
