class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for(char c: t.toCharArray()){
            map[c]++;
        }

        int l = 0;
        int cnt = 0;
        int start = -1;
        int len = Integer.MAX_VALUE;
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);

            if(map[c] > 0){
                cnt++;
            }
            map[c] --;
            
            while(cnt == t.length()){
                if(r-l+1 < len){
                    start = l;
                    len = r-l+1;
                }

                map[s.charAt(l)]++;
                if(map[s.charAt(l)] > 0){
                    cnt--;
                }
                l++;
            }
        }

        return start == -1? "" : s.substring(start, start+len);

    }
}