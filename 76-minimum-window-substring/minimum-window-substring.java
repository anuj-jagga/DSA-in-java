class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            map[c]++;
        }

        int l=0;
        int idx = -1;
        int minLen = Integer.MAX_VALUE;
        int cnt = 0;

        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            if(map[ch] > 0) cnt++;
            map[ch]--;

            while(cnt == t.length()){ // due to cnt we know that if our window contains every char of String t
                if(r-l+1 < minLen){
                    idx = l;
                    minLen = r-l+1;
                }
                map[s.charAt(l)]++;
                if(map[s.charAt(l)] > 0) cnt--;
                l++;
            }
        }

        return idx==-1 ? "" : s.substring(idx,idx+minLen);
    }
}