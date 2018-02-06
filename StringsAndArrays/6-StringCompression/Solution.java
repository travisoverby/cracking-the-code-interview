import java.util.*;

public class Solution {

    public static void main(String[] args) {
        test("aaabbbcccdddeee", "a3b3c3d3e3");
        test("abcde", "abcde");
        test("aaaaabbcccccddaaa", "a5b2c5d2a3");
        test("aaabbbcccdddeee", "a3b3c3d3e3");
    }
  
    public static void test(String input, String expectedResult) {
        String result = compress(input);

        System.out.println("Input           : " + input);
        System.out.println("Expected result : " + expectedResult);
        System.out.println("Actual result   : " + result);    
        System.out.println();
    }

    private static String compress(String input) {
        StringBuilder compress = new StringBuilder();
        int length = input.length();
        int compressLength = 0;
        int charCount = 0;

        for (int i = 0; i < length; i++) {
            charCount++;
            if (i+1 == (length) || input.charAt(i) != input.charAt(i+1)) {
                compress.append(input.charAt(i));
                compress.append(charCount);
                compressLength += 2;
                if (length < compressLength) return input;
                charCount = 0;
            } 
        }

        return compress.toString();
    }
        

}
