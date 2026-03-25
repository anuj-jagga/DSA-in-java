class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int add = 1;
        for(int i=n-1;i>=0;i--){
            if(digits[i]==9){
                digits[i] = 0;
            }else{
                digits[i]+= add;
                return digits;
            }
        }

        int[] newArr = new int[n+1];
        newArr[0] = 1;
        for(int i=1;i<=n;i++){
            newArr[i] = digits[i-1];
        }
        return newArr;
    }
}