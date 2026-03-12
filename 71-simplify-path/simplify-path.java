class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        for(String str : path.split("/")){
            if(str.equals("") || str.equals(".")){
                continue;
            }
            else if(str.equals("..")){
                if(st.size() > 0){
                    st.pop();
                }
            }
            else{
                st.push(str);
            }
        }

        StringBuilder res = new StringBuilder();

        for(String dir : st){
            res.append("/").append(dir);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}