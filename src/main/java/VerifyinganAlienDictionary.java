import java.util.Arrays;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/description/
 * 953
 *In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 * best code vs my code (checked with chatgpt)
 */

/**
 * best code memory usage
 */
public class VerifyinganAlienDictionary {
    int[] idx = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++)
            idx[order.charAt(i) - 'a'] = i;
//        System.out.println(Arrays.toString(idx));
//        System.out.println(Arrays.toString(words));
//        System.out.println(order);
        for (int i = 1; i < words.length; i++)
            if (bigger(words[i - 1], words[i]))
                return false;
        return true;
    }

    boolean bigger(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        for (int i = 0; i < n && i < m; ++i)
            if (s1.charAt(i) != s2.charAt(i)) {
//                System.out.println(idx[s1.charAt(i) - 'a'] + " " + idx[s2.charAt(i) - 'a']);
                return idx[s1.charAt(i) - 'a'] > idx[s2.charAt(i) - 'a'];
            }
        return n > m;
    }
}

// initial code
//class Solution {
//    public static boolean isAlienSorted(String[] words, String order) {
//
//        return wizard(words,order,0,0);
//
//    }
//
//    public static boolean wizard(String[] words, String order,int position,int step){
//        String worda=words[step];
//        String wordb=words[step+1];
//        boolean flag=words.length==step+2;
//        System.out.println(position+"--"+worda+"--"+wordb);
//        int a = position>= worda.length()? -1: order.indexOf(worda.charAt(position));
//        int b=  position>= wordb.length()? -1: order.indexOf(wordb.charAt(position));
//        if (a>b) return false;
//        if (a<b) {
//            if(flag) return true;
//            position=0;
//            step++;
//            return wizard(words,order,position,step);
//        }
//
//        if (a==b) {
//
//            if(worda.length()==position+1 && flag){
//                return true;
//            }
//            if(worda.length()==position+1) {
//                step++;
//                position=0;
//                return wizard(words,order,position,step);
//            }
//            position++;
//            return wizard(words,order,position,step);
//
//        }
//        return false;
//
//    }
//}