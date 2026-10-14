class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] freq = new int[26];

        // Characters required from p
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character to window
            freq[s.charAt(right) - 'a']--;

            // Keep window size = p.length()
            if (right - left + 1 > p.length()) {
                freq[s.charAt(left) - 'a']++;
                left++;
            }

            // If frequencies are all 0, it's an anagram
            if (right - left + 1 == p.length()) {

                boolean same = true;

                for (int i = 0; i < 26; i++) {
                    if (freq[i] != 0) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    ans.add(left);
                }
            }
        }

        return ans;
    }
}