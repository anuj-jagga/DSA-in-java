class Solution {
    public int minAddToMakeValid(String s) {
        // can be also done by stack
        // but instead of stack we mantain variable size which will act as a stack

        int size = 0;  // total extra opening brackets
        int open = 0; // total extra closing brackets

        for(char ch : s.toCharArray()){
            if(ch == '('){
                size++;
                continue;
            } 

            if(ch == ')' && size == 0){
                open++;
            }else{
                size--;
            }
        }

        return open + size;  // for stack, it means open + st.size()
    }
}