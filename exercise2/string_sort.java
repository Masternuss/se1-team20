package exercise2;

import java.util.Arrays;

public class string_sort implements sort_a_string{

    static boolean isWellSorted(String[] sequence){
        String in = String.join("", sequence);
        char[] chars = in.toCharArray();
        char[] sorted_chars = new char[chars.length];
        for (int i = 0; i < chars.length; i++){
            sorted_chars[i] = chars[i];
        }
        Arrays.sort(sorted_chars);
        return Arrays.equals(chars, sorted_chars);
    }



}
