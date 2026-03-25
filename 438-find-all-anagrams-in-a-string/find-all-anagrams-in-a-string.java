import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s.length() < p.length()) return result;
        
        int[] count = new int[26];
        
        // Count frequency of characters in p
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        
        int left = 0, right = 0, required = p.length();
        
        while (right < s.length()) {
            // If char is needed, decrease required
            if (count[s.charAt(right) - 'a'] > 0) {
                required--;
            }
            
            count[s.charAt(right) - 'a']--;
            right++;
            
            // When window size equals p length
            if (required == 0) {
                result.add(left);
            }
            
            // Maintain window size
            if (right - left == p.length()) {
                if (count[s.charAt(left) - 'a'] >= 0) {
                    required++;
                }
                count[s.charAt(left) - 'a']++;
                left++;
            }
        }
        
        return result;
    }
}