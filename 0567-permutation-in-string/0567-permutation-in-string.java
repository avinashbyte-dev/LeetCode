class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Frequency of s1
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        // First window of s2
        for (int i = 0; i < s1.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(freq1, freq2)) {
            return true;
        }

        // Sliding window
        for (int right = s1.length(); right < s2.length(); right++) {

            // Add new character
            freq2[s2.charAt(right) - 'a']++;

            // Remove old character
            int left = right - s1.length();
            freq2[s2.charAt(left) - 'a']--;

            // Check frequencies
            if (matches(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}