class StockSpanner {
    class Pair{
        int val,c;
        Pair(int val,int c){
            this.val = val;
            this.c = c;
        }
    }

    Stack<Pair> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int cnt = 1;
        while(!st.isEmpty() && st.peek().val <= price){
            cnt += st.pop().c;
        }
        st.push(new Pair(price,cnt));
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */