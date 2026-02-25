class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];

        // Count characters of s1
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
        
            freq[s2.charAt(right) - 'a']--;

            if (right - left + 1 > s1.length()) {
                freq[s2.charAt(left) - 'a']++;
                left++;
            }

            // If all frequencies are zero, we found permutation
            if (allZero(freq)) return true;
        }

        return false;
    }

    private boolean allZero(int[] freq) {
        for (int num : freq) {
            if (num != 0) return false;
        }
        return true;
    }
}