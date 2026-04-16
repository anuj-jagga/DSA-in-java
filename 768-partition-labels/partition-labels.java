class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int[] map = new int[26];
        for(int i=0;i<n;i++){
            map[s.charAt(i) - 'a'] = i; // store last occurence of each char in map
        }

        int start = 0;
        int end = 0;

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            end = Math.max(end,map[c-'a']);

            if(end == i){
                res.add(end - start + 1);
                start = i+1;
            }
        }
        return res;
    }
}