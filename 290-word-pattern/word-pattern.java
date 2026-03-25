class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        int j=0;
        for(char ch : pattern.toCharArray()){
            if(j>=s.length()) return false;
            String temp = "";
            while(j<s.length() && s.charAt(j)!=' '){
                temp += s.charAt(j);
                j++;
            }
            j++;
    
            if(map.containsKey(ch) && !map.get(ch).equals(temp) || !map.containsKey(ch) && map.containsValue(temp)){
                return false;
            }
            map.put(ch,temp);
        }
        return j < s.length()? false: true;
    }
}