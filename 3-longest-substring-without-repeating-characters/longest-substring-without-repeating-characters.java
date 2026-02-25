class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0;
        int longest = 0;
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            
            if(map.containsKey(c)){
                if(map.get(c) >= l){
                    l = map.get(c)+1;
                }
            }
            map.put(c,r);
            longest = Math.max(longest,r-l+1);
        }
        
        return longest;
    }
}