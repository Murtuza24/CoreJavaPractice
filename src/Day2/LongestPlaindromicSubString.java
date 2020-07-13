package Day2;

import java.util.Scanner;

public class LongestPlaindromicSubString {
    public static void main(String[] args) {
        System.out.println("Enter String: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        abcbab
        System.out.println("Longest Palindrome: " + getLongestPalindrome(str));
    }

    private static String getLongestPalindrome(String str) {

        if (str == null || str.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        String longestPalindrome = "";
        for (int i = 0; i < str.length(); i++) {
//            check palindrome for even leghts eg: aa and odd lengths eg: aba
            int len1 = checkPalindrome(str, i, i);
            int len2 = checkPalindrome(str, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private static int checkPalindrome(String st, int low, int high) {

        while (low >= 0 && high < st.length() && st.charAt(low) == st.charAt(high)) {
//            palindrome = str.substring(low, high);
            low--;
            high++;
        }
        return high - low - 1;
    }
}
