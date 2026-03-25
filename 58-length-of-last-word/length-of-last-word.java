class Solution {
    public int lengthOfLastWord(String s) {
        boolean flag = false;
        int len=0;

        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(!flag && ch == ' '){
                continue;
            }
            flag = true;
            if(flag && ch!=' '){
                len++;
            }else{
                break;
            }
        }
        return len;
    }
}