import java.util.*;

public class Solution {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private static boolean match(String w, String p) {
        if (w.length() != p.length()) return false;

        int[] m1 = new int[26];
        int[] m2 = new int[26];
        Arrays.fill(m1, -1);
        Arrays.fill(m2, -1);

        for (int i = 0; i < w.length(); i++) {
            int c1 = w.charAt(i) - 'a';
            int c2 = p.charAt(i) - 'a';

            if (m1[c2] == -1 && m2[c1] == -1) {
                m1[c2] = c1;
                m2[c1] = c2;
            } else if (m1[c2] != c1 || m2[c1] != c2) {
                return false;
            }
        }
        return true;
    }
}