package com.som.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */


public class Main {

    static boolean checkParamsNotNull(String... params) {
        if (params == null) throw new IllegalArgumentException("Not null vararg expected.");
        if (params.length == 0) throw new IllegalArgumentException("At list one param expected.");
        for (String param : params) {
            if (param == null) return false;
        }
        return true;
    }

    static void checkParamWithoutTabooSubString(String tabooSubString, String param) {
        if (param.contains(tabooSubString)) {

            throw new RuntimeException("Param: [" + param + "] contains illegal substring: [" + tabooSubString + "]");
        }
    }


    static void checkParamWithoutTabooSubStrings(List<String> tabooSubStrings, String param) {
        for (String tabooSubString : tabooSubStrings) {
            checkParamWithoutTabooSubString(tabooSubString, param);
        }
    }

    static void checkParamsWithoutTabooSubStrings(List<String> tabooSubStrings, String... params) {
        if (params == null) throw new IllegalArgumentException("Not null vararg expected.");
        if (params.length == 0) throw new IllegalArgumentException("At list one param expected.");
        if (tabooSubStrings == null) throw new IllegalArgumentException("Not null list of tabooSubStrings expected.");
        if (tabooSubStrings.size() == 0) return;
        for (String param : params) {
            checkParamWithoutTabooSubStrings(tabooSubStrings, param);
        }
    }

    static List<String> getTabooSubStrings() {
        List<String> tabooStrings = new ArrayList<String>();
        tabooStrings.add("\n");
        tabooStrings.add("\t");
        return tabooStrings;
    }

    public static void main(String[] args) {
//        String[] arr = {"a", "b"};
//        List l = Arrays.asList(arr);
//        System.out.println(l.size());

        System.out.println(checkParamsNotNull("aa", "cc", "aa"));


        checkParamsWithoutTabooSubStrings(getTabooSubStrings(), "bb", "aa\n");
    }
}
