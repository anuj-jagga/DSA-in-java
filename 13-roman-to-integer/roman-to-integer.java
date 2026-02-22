class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1){
                ans += map.get(s.charAt(i));
                break;
            }
            char cur = s.charAt(i);
            char nxt = s.charAt(i+1);

            if(map.get(cur) >= map.get(nxt)){
                ans += map.get(cur);
            }else{
                ans -= map.get(cur);
            }
        }
        return ans;
    }
}