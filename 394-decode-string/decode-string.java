class Solution {
    public String decodeString(String s) {
        StringBuilder curr = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack();
        int num = 0;

        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num*10 +(ch-'0'); //understand it
            }
            else if(ch == '['){
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder("");
            }
            else if(ch == ']'){
                int repeat = numStack.pop();
                StringBuilder prev = strStack.pop();
                for(int i=0; i < repeat; i++){
                    prev.append(curr);
                }
                curr = prev;
            }
            else{
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}