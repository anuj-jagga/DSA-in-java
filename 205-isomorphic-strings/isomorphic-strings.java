class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character,Character> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            char d = t.charAt(i);
            if(!map.containsKey(c) && !map.containsValue(d)){
                map.put(c,d);
            } 
            else if(!map.containsKey(c) || map.get(c)!=d) return false;
        }

        return true;
    }
}