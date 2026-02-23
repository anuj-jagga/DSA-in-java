class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean[] vis = new boolean[n];
        List<List<String>> res = new ArrayList<>();
        int idx = 0;
        for(int i=0;i<n;i++){
            if(vis[i]) continue;
            String s = strs[i];
            res.add(new ArrayList<>());
            res.get(idx).add(s);
            for(int j = i+1;j<n;j++){
                String t = strs[j];
                if(isAnagram(s,t)){
                    res.get(idx).add(t);
                    vis[j] = true;
                }
            }
            idx++;
        }

        return res;
    }

     public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        int[] count = new int[26];

        for(char c:s.toCharArray()){
            count[c-'a']++;
        }

        for(char c:t.toCharArray()){
            count[c-'a']--;
            if(count[c-'a']<0) return false;
        }
        
        return true;
    }
}