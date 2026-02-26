class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int candidate1 = 0;
        int candidate2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int num : nums){
            if(num ==candidate1){
                cnt1++;
            }
            else if(num  == candidate2){
                cnt2++;
            }
            else if(cnt1 == 0){
                candidate1 = num;
                cnt1++;
            }
            else if(cnt2 == 0){
                candidate2 = num;
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--; 
            }
        }

        // verify
        cnt1 = 0;
        cnt2 = 0;

        for(int num:nums){
            if(num == candidate1) cnt1++;
            if(num == candidate2) cnt2++;
        }

        ArrayList<Integer> res = new ArrayList<>();
        if(cnt1> n/3){
            res.add(candidate1);
        }
        if(candidate2 != candidate1 && cnt2> n/3){
            res.add(candidate2);
        }
        return res;
    }
}