package com.bounegru;

public class Main {

    public static void main(String[] args) {
        String first = args[0];
        String second = args[1];
        System.out.println(resolve(first, second));
    }

    public static String resolve(String first, String second) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < second.length(); i++) {
            if (second.charAt(i) == '*') {
                int tempIndex = first.indexOf(String.valueOf(temp));
                if (tempIndex == -1) {
                    return "KO";
                }
                first = first.substring(first.indexOf(String.valueOf(temp)) + temp.length());

                temp = new StringBuilder();
                continue;
            }
            temp.append(second.charAt(i));
        }
        if (first.equals(second) || first.endsWith(String.valueOf(temp))) {
            return "OK";
        } else {
            return "KO";
        }
    }
}
