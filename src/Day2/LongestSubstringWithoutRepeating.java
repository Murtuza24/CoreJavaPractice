package Day2;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println("Enter String: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Max Len: "+getLongestSubstring(str));
    }

    private static int getLongestSubstring(String str) {
        HashSet<Character> characterHashSet = new HashSet<Character>();
        int maxSub = 0;
        String longest = "";
        for (int low = 0; low < str.length(); low++){
            characterHashSet.add(str.charAt(low));
            int high = low+1;
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
                    count++;
                    high++;
                }
            }
            maxSub = Math.max(maxSub, count);
        }
        return maxSub;
    }
}
