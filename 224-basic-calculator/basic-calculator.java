class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int num = 0;
        int res = 0;

        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(res);
                st.push(sign);
                res = 0; // start building again for current bracket
                sign = 1;
            }

            if(ch == ')'){
                res += sign*num;
                res *= st.pop(); // sign
                res  += st.pop(); // res we added in stack when bracket was started
                num = 0;
            }
            
            else if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
            }
            else if(ch == '-'){
                // number ban chuka hoga already, res mein add karo
                res += sign*num;
                num = 0;
                sign = -1;
            }
            else if(ch == '+'){
                res += sign*num;
                num = 0;
                sign = 1;
            }
        }

        return res += sign*num; // dry run for test case "1+2+3" you'll know why
    }
}