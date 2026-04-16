class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int cnt = 1;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                cnt++;
                set.clear();
            }
            set.add(ch);
        }
        return cnt;
    }
}