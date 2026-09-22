class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int el = 0;

        for(int num:nums){
            if(cnt == 0){
                el = num;
                cnt++;
            }
            else if(el == num) cnt++;
            else cnt--;
        }
        return el;
    }
}