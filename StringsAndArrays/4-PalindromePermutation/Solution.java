import java.util.*;

public class Solution {

    public static void main(String[] args) {
        test("noon", true);
        test("racecar", true);
        test("monkey", false);
        test("12345654321", true);
        test("11223344556", true);
    }
  
    public static void test(String input, boolean expectedResult) {
        boolean result = palindromePermutation(input);

        System.out.println("Input           : " + input);
        System.out.println("Expected result : " + expectedResult);
        System.out.println("Actual result   : " + result);    
        System.out.println();
    }

    private static boolean palindromePermutation(String input) {
        HashMap<Character, Integer> charset = getCharset(input);
        boolean hasOddValue = false;

        for (int num : charset.values()) {
            if (num % 2 == 1) {
                if (hasOddValue) return false;
                hasOddValue = true;
            }
        }
        return true;

    }

    private static HashMap<Character, Integer> getCharset(String input) {
        HashMap<Character, Integer> charset = new HashMap<Character, Integer>();

        for (char c : input.toCharArray()) {
            if (charset.get(c) != null) {
                int val = charset.get(c);
                charset.put(c, val + 1);
            } else {
                charset.put(c, 1);
            }
        }

        return charset;
    }

}
