class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq = new int[26];

        // Count characters needed from s1
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            // Add current character
            freq[s2.charAt(right) - 'a']--;

            // Keep window size = s1.length()
            if (right - left + 1 > s1.length()) {
                freq[s2.charAt(left) - 'a']++;
                left++;
            }

            // Check if frequencies match
            if (right - left + 1 == s1.length()) {

                boolean same = true;

                for (int i = 0; i < 26; i++) {
                    if (freq[i] != 0) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    return true;
                }
            }
        }

        return false;
    }
}