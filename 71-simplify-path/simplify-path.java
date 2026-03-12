class Solution {
    public String simplifyPath(String s) {
        ArrayList<String> list = new ArrayList<>();
        int n = s.length();
        String curr = "";

        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);

            if(ch == '/' && s.charAt(i-1) != '/'){
                list.add(curr);
                curr = "";
                continue;
            }

            if(ch != '/')
                curr += ch;
        }

        list.add(curr);

        ArrayList<String> stack = new ArrayList<>();

        for(String str : list){
            if(str.equals("") || str.equals(".")){
                continue;
            }
            else if(str.equals("..")){
                if(stack.size() > 0)
                    stack.remove(stack.size() - 1);
            }
            else{
                stack.add(str);
            }
        }

        StringBuilder res = new StringBuilder();

        for(String dir : stack){
            res.append("/").append(dir);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}