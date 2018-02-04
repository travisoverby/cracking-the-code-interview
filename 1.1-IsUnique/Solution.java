import java.util.*;

public class Solution {

  public static void main(String[] args) {
    IsUnique.test("abcdefghijklmnopqrstuvwxyz", true);   
  }

  private static class IsUnique {
    
    public static void test(String input, boolean expectedResult) {
      boolean actualResult = isUnique(input);
      
      System.out.println("Input           : " + input);
      System.out.println("Expected result : " + expectedResult);
      System.out.println("Actual result   : " + actualResult);    
      System.out.println();
    }

    private static boolean isUnique(String input) {
      Set<Character> chars = new HashSet<Character>();
      for (char c : input.toCharArray()) {
        if (chars.contains(c)) {
          return false;
        } else {
          chars.add(c);
        }
      } 
     return true;
    }

  }

}
