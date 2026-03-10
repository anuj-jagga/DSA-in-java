class Solution {
    public String removeDuplicates(String s) {
        int len = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(len!=0 && s.charAt(i) == sb.charAt(len-1)){
                sb.deleteCharAt(sb.length()-1);
                len--;
            }else{
                sb.append(s.charAt(i));
                len++;
            }
        }
        return sb.toString();
    }
}