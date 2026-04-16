class Solution {
    public int partitionString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int cnt = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)>1){
                cnt++;
                map.clear();
                map.put(ch,1);
            }
        }
        return ++cnt;
    }
}