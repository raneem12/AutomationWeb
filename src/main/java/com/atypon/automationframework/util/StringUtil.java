package com.atypon.automationframework.util;

public class StringUtil {
    /**
     * String Operation: check on two string are equals case insensitive.
     * @param txt1 the first sequence of chars.
     * @param txt2 the second sequence of chars.
     * @return true if the {txt1} is insensitive equal to txt2, otherwise false.
     * */
    public static boolean equalsIgnoreCase(String txt1, String txt2) {
        return hasText(txt1) && hasText(txt2) && toLower(trim(txt1)).equals(toLower(trim(txt2)));
    }

    public static boolean equals(String txt1, String txt2) {
        return (hasText(txt1) && hasText(txt2)) && txt1.equals(txt2);
    }

    public static boolean hasText(String txt) {
        return txt != null && txt.length() > 0;
    }

    public static String trim(String txt) {
        return hasText(txt) ? txt.trim() : txt;
    }

    public static String toLower(String txt) {
        return hasText(txt) ? txt.toLowerCase() : txt;
    }
}
