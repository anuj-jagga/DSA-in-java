class Solution {
    public String convert(String s, int numRows) {
        // just crame it
        
        if (numRows == 1 || numRows >= s.length()) return s;
        StringBuilder[] rows = new StringBuilder[numRows+1];
        for(int i=1;i<=numRows;i++) rows[i] = new StringBuilder();

        boolean goingDown = false;
        int currRow = 1;
        for(char ch : s.toCharArray()){
            rows[currRow].append(ch);
            if(currRow == 1 || currRow == numRows){
                goingDown = !goingDown;
            }
            currRow += goingDown? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for(int i=1; i<=numRows;i++){
            res.append(rows[i]);
        }
        return res.toString();
    }
}