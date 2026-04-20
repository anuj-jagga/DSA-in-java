class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        int longest = 0;
        for(int r=0; r<s.length();r++){
            char c = s.charAt(r);
            freq[c-'A']++;
            maxFreq = Math.max(maxFreq, freq[c-'A']);

            while(r-l+1 - maxFreq > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            longest = Math.max(longest, r-l+1);
        }
        return longest;
    }
}