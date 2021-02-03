package com.bounegru;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int MAX_CHARS = 256;

    public static void main(String[] args) {

        if (args.length == 2) {
            System.out.println("Number: " + iToBase(Integer.parseInt(args[0]), args[1]));
        } else if (args.length == 3) {
            System.out.println("Number: " + iToBase(args[0], args[1], args[2]));
        } else {
            System.out.println("Invalid input data");
        }
    }

    public static String iToBase(int nb, String base) {
        if (!uniqueCharacters(base)) {
            return ("number system contains non-unique characters");
        }
        StringBuilder result = new StringBuilder();
        int length = base.length();
        while (nb > 0) {
            result.append(base.charAt(nb % length));
            nb /= length;
        }
        return result.reverse().toString();
    }

    public static String iToBase(String nb, String baseSrc, String baseDst) {
        if (!uniqueCharacters(baseSrc) || !uniqueCharacters(baseDst)) {
            return ("number system contains non-unique characters");
        }
        StringBuilder temp = new StringBuilder();
        int nbDecimal = 0;
        // base src to decimal
        for (int i = 0; i < nb.length(); i++) {
            int number = baseSrc.indexOf(nb.charAt(i));
            nbDecimal += number * (int) Math.pow(baseSrc.length(), nb.length() - 1 - i);

//            temp.append(baseSrc.indexOf(nb.charAt(i)));
        }


        return iToBase(nbDecimal, baseDst);
    }

    public static boolean uniqueCharacters(String str) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
