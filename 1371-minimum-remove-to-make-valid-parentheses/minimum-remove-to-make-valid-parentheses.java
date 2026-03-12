class Solution {
    public String minRemoveToMakeValid(String s) {
        boolean[] remove = new boolean[s.length()];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else if(ch == ')'){
                if(st.isEmpty()){
                    remove[i] = true;
                }else{
                    st.pop();
                }
            }
        }

        while(!st.isEmpty()){
            remove[st.pop()] = true;
        }
        StringBuilder res = new StringBuilder();

        for(int i=0; i< s.length();i++){
            if(!remove[i]) res.append(s.charAt(i));
        }
        return res.toString();
    }
}