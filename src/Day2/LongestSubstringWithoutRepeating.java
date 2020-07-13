package Day2;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println("Enter String: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Longest Substring: "+getLongestSubstring(str));
    }

    private static String getLongestSubstring(String str) {
//        We maintain a hashset to keep record of seen chars so far.
//        if char repeats then the hashset is reset/cleared and the max length
//        is updated in the maxSub variable and the longest substring is updated in a StringBuilder variable.

        HashSet<Character> characterHashSet = new HashSet<Character>();
        int maxSub = 0;
        String output = "";
        StringBuilder longest = new StringBuilder();
        for (int low = 0; low < str.length(); low++){
            characterHashSet.add(str.charAt(low));
            longest.append(str.charAt(low));
            int high = low + 1;
            int count = 1;
            while(high < str.length()){
                System.out.println(characterHashSet.toString());
                System.out.println(str.charAt(low)+","+str.charAt(high));
                if(characterHashSet.contains(str.charAt(high))) {
                    System.out.println("--------------------");
                    characterHashSet.clear();
                    break;
                } else{
                    characterHashSet.add(str.charAt(high));
                    longest.append(str.charAt(high));
                    count++;
                    high++;
                }
            }

            if (longest.length() > output.length()){
                output = longest.toString();

            }
            longest = new StringBuilder();
            maxSub = Math.max(maxSub, count);
        }
        System.out.println("Max Len: "+maxSub);
        return output;
    }
}
