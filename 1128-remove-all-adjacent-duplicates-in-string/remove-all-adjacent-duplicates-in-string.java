class Solution {
    public String removeDuplicates(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!sb.isEmpty() && map.containsKey(c) && sb.charAt(sb.length()-1) == c){
                sb.deleteCharAt(sb.length()-1);
                continue;
            }
            map.put(c,1);
            sb.append(c);
        }
        return sb.toString();
    }
}