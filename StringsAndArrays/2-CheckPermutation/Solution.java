import java.util.*;

public class Solution {

    public static void main(String[] args) {
        test("123456", "654321", true);
        test("meat", "teams", false);
        test("noon", "noons", false);
        test("meat", "team", true);
    }

  
    public static void test(String input1, String input2, boolean expectedResult) {
        boolean actualResult = checkPermutation(input1, input2);
    
        System.out.println("Input 1         : " + input1);
        System.out.println("Input 2         : " + input2);
        System.out.println("Expected result : " + expectedResult);
        System.out.println("Actual result   : " + actualResult);    
        System.out.println();
    }

    private static boolean checkPermutation(String input1, String input2) {
        Map<Character, Integer>  chars = new HashMap<Character, Integer>();

        for (char c : input1.toCharArray()) {
            if (chars.containsKey(c)) {
                int count = chars.get(c);
                chars.put(c, count + 1);
            } else {
                chars.put(c, 1);
            }
        }

        for (char c : input2.toCharArray()) {
            if (!chars.containsKey(c)) return false;
            int count = chars.get(c);
            if (count - 1 < 0) return false;
            chars.put(c, count - 1);
        }

        return true;
    }

}
