class Solution {
    public String minRemoveToMakeValid(String s) {
        ArrayList<Integer> list1 = new ArrayList<>();
        Stack<int[]> st = new Stack<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.add(new int[]{ch,i});
            }
            else if(ch == ')'){
                if(st.isEmpty()){
                    list1.add(i);
                }else{
                    st.pop();
                }
            }
        }

        StringBuilder res = new StringBuilder();
         ArrayList<Integer> list2 =  new ArrayList<>();

        if(!st.isEmpty()){
            for(int[] a : st){
                list2.add(a[1]);
            }
        }

        for(int i=0;i<s.length();i++){
            if(list2.contains(i) || list1.contains(i)) continue;
            res.append(s.charAt(i));
        }
        

        return res.toString();
    }
}