import java.util.*;

public class Solution {

    public static void main(String[] args) {
        test("There is no spoon!", "There%20is%20no%20spoon!");
        test("cat in the hat", "cat%20in%20the%20hat");
    }

  
    public static void test(String input, String expectedResult) {
        String result = URLify(input);
        System.out.println("Input           : " + input);
        System.out.println("Expected result : " + expectedResult);
        System.out.println("Actual result   : " + result);    
        System.out.println();
    }

    private static String URLify(String input) {
        char[] padded = getPaddedInput(input);
        
        int endRef = padded.length - 1;
        for (int i = input.length() - 1; i > 0; i--) {
            if (padded[i] == ' ') {
                padded[endRef--] = '0';
                padded[endRef--] = '2';
                padded[endRef--] = '%';
            } else {
                padded[endRef--] = padded[i];
            }
        }

        return new String(padded);

    }

    private static char[] getPaddedInput(String input) {
        int spaceCount = 0;
        for (char c : input.toCharArray()) {
            if (c == ' ') spaceCount++;
        }

        char[] paddedInput = new char[input.length() + (2 * spaceCount)];

        for (int i = 0; i < input.length(); i++) {
            paddedInput[i] = input.charAt(i);
        }

        return paddedInput;
    }

}
