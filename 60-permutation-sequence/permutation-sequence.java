class Solution {
    int cnt = 0;
    String ans = "";
    boolean[] used;
    public String getPermutation(int n, int k) {
        used = new boolean[n+1];
        rec(n,k,new StringBuilder());
        return ans;
    }

    void rec(int n,int k, StringBuilder temp){
        if(!ans.equals("")) return;
        if(temp.length() == n){
            cnt++;
            if(cnt == k){
                ans = temp.toString();
            }
            return;
        }

        for(int i=1;i<=n;i++){
            if(used[i]) continue;

            used[i] = true;
            temp.append(i);
            rec(n,k,temp);
            temp.deleteCharAt(temp.length()-1);
            used[i] = false;
        }
    }
}