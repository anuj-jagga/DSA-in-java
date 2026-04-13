class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && s.charAt(i)==st.peek()){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(char c:st) sb.append(c);
        return sb.toString();
    }
}