class Solution {
    class Pair{
        int cnt;
        char ch;
        Pair(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();

        for(char c:s.toCharArray()){
            if(!st.isEmpty() && c == st.peek().ch){
                Pair p = st.pop();
                st.push(new Pair(c,p.cnt+1));
                if(st.peek().cnt== k){
                    st.pop();
                }
            }
            else{
                st.push(new Pair(c,1));
            } 


        }

        StringBuilder sb = new StringBuilder();
        for(Pair p: st){
            for(int i=0;i<p.cnt;i++){
                sb.append(p.ch);
            }
        }

        return sb.toString();
    }
}