class Solution {
    public int firstUniqChar(String s) {
        // Queue<Integer> q = new LinkedList<>();
        // for(char c:s.toCharArray()){
        //     if()
        // }
        // return q.pop();

        Map<Character,Integer> map = new LinkedHashMap<>();

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.get(c)==1) return i;
        }

        return -1;
    }
}