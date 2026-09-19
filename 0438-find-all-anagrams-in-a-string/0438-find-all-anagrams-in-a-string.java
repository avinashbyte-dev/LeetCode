class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) return ans;

        int[] freq = new int[26];

        // Frequency of characters in p
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {

            // Add current character to window
            if (freq[s.charAt(right) - 'a'] > 0) {
                count--;
            }

            freq[s.charAt(right) - 'a']--;
            right++;

            // Window becomes larger than p
            if (right - left > p.length()) {
                if (freq[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }

                freq[s.charAt(left) - 'a']++;
                left++;
            }

            // All required characters are present
            if (count == 0) {
                ans.add(left);
            }
        }

        return ans;
    }
}