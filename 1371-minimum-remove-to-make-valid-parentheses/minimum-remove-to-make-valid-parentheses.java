class Solution {
    public String minRemoveToMakeValid(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else if(ch == ')'){
                if(st.isEmpty()){
                    list.add(i);
                }else{
                    st.pop();
                }
            }
        }

        while(!st.isEmpty()){
            list.add(st.pop());
        }
        StringBuilder res = new StringBuilder();

        for(int i=0; i< s.length();i++){
            if(!list.contains(i)) res.append(s.charAt(i));
        }
        return res.toString();
    }
}