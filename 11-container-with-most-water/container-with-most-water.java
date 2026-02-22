class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int ans = 0;
        while(i<j){
            int width = j-i;
            int hgt = Math.min(height[i],height[j]);
            ans = Math.max(ans,hgt*width);
            if(height[i]<=height[j]){
                i++;
            }else{
                j--;
            }
        }

        return ans;
    }
}