class Solution {
    class Pair{
        char c;
        int cnt;
        Pair(char c,int cnt){
            this.c = c;
            this.cnt = cnt;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek().c == ch){
                Pair p = st.pop();
                st.push(new Pair(ch,p.cnt+1));
            }else{
                st.push(new Pair(ch,1));
            }

            if(st.peek().cnt == k){
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Pair p:st){
            int cnt = p.cnt;
            for(int i=0;i<cnt;i++){
                sb.append(p.c);
            }
        }

        return sb.toString();
    }

}