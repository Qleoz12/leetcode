import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *https://leetcode.com/problems/remove-letter-to-equalize-frequency/description/
 *You are given a 0-indexed string word, consisting of lowercase English letters. You need to select one index and remove the letter at that index from word so that the frequency of every letter present in word is equal.
 *
 * Return true if it is possible to remove one letter so that the frequency of all letters in word are equal, and false otherwise.
 *
 * Note:
 * The frequency of a letter x is the number of times it occurs in the string.
 * You must remove exactly one letter and cannot chose to do nothing.
 *
 * Example 1:
 * Input: word = "abcc"
 * Output: true
 * Explanation: Select index 3 and delete it: word becomes "abc" and each character has a frequency of 1.
 *
 * Example 2:
 * Input: word = "aazz"
 * Output: false
 * Explanation: We must delete a character, so either the frequency of "a" is 1 and the frequency of "z" is 2, or vice versa. It is impossible to make all present letters have equal frequency.
 *
 */
public class RemoveLetterToEqualizeFrequency{

    public static void main(String[] args) {

//        System.out.println(equalFrequency("abcc"));
//        System.out.println(equalFrequency("aazz"));
//        System.out.println(equalFrequency("bac"));
//        System.out.println(equalFrequency("ddaccb"));
//        System.out.println(equalFrequency("abbcc"));
//        System.out.println(equalFrequency("zz"));
//        System.out.println(equalFrequency("cccd"));
        System.out.println(equalFrequency("cccaa"));
        //


    }

    /**
     * mi inital code
     * @param word
     * @return
     */
    public static boolean equalFrequency(String word) {
        HashMap<Character, Integer> checkSum = new HashMap<Character, Integer>();
        int promedio=0;
        for ( int i = 0; i < word.length(); ++i )
        {
            if(checkSum.get(word.charAt(i))==null){
                checkSum.put(word.charAt(i), 1);
            }else
            {
                checkSum.put(word.charAt(i), checkSum.get(word.charAt(i))+1);
            }
        }


        int[] arr=checkSum.values().stream()
                .sorted(Collections.reverseOrder())
                .mapToInt(i->i).toArray();
        int mode = calculateMode(arr);

        int diferencia=0;
        for (Map.Entry<Character, Integer> set :checkSum.entrySet()) {
            diferencia+=Math.abs(mode- set.getValue());
        }
        System.out.println();
        System.out.println("la moda es "+mode);
        System.out.println(diferencia);
        if((mode==1 && diferencia<=1 ) || (diferencia==1 && checkSum.size()==2) || diferencia==mode-1 || checkSum.size()==1) {
            return true;
        }

        return false;

    }

    public static int calculateMode(int[] arr) {
        int mode = 0;
        int maxFreq = 0;
        int currFreq = 1;

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                currFreq++;
            } else {
                if (currFreq > maxFreq) {
                    maxFreq = currFreq;
                    mode = arr[i - 1];
                }
                currFreq = 1;
            }
        }

        // Handle the last element
        if (currFreq >= maxFreq) {
            mode = arr[arr.length - 1];
        }

        return mode;
    }

    /**
     * best code
     */

    /*private static final int A = 'a';
    private static final int L = 26;

    public boolean equalFrequency(String word) {
        int[] frequencies = new int[L];
        int len = word.length();
        for(int i = 0; i < len; i++) {
            frequencies[word.charAt(i) - A]++;
        }

        int minFreq = Integer.MAX_VALUE;
        for(int i = 0; i < L; i++) {
            int f = frequencies[i];
            if(f == 0) {
                frequencies[i] = -1;
            } else if(f < minFreq) {
                minFreq = f;
            }
        }

        for(int i = 0; i < L; i++) {
            if(frequencies[i] > 0) {
                frequencies[i] -= minFreq;
            }
        }

        int zerosCount = 0, onesCount = 0, otherCount = 0;
        for(int i = 0; i < L; i++) {
            int f = frequencies[i];
            if(f < 0) continue;
            else if(f == 0) zerosCount++;
            else if(f == 1) onesCount++;
            else {
                if(otherCount > 1) return false;
                otherCount++;
            }
        }
        return (onesCount == 1 && otherCount == 0)
            || (zerosCount == 1 && onesCount == 0 && otherCount == 0)
            || (zerosCount > 0 && onesCount == 0 && otherCount == 0 && minFreq == 1)
            || (zerosCount == 1 && (onesCount > 0 ^ otherCount > 0) && minFreq == 1);
    }*/
}
