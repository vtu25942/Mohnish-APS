class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        // Try all possible substring lengths
        for (int i = 1; i <= n / 2; i++) {
            // Check if i divides n
            if (n % i == 0) {
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                
                // Repeat substring
                for (int j = 0; j < n / i; j++) {
                    sb.append(sub);
                }
                
                // Compare with original string
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}