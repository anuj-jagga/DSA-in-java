import java.util.Scanner;

public class Solution {

    public static int trap(int height[]){
        int n = height.length;
        
        if(n==0) return 0;

        int left_max[] = new int[n];
        int right_max[] = new int[n];

        left_max[0]= height[0];

        for(int i = 1;i<n;i++){
            left_max[i] = Math.max(left_max[i-1], height[i]);
        }

        right_max[n-1] = height[n-1];

        for(int i=n-2;i>=0;i--){
            right_max[i] = Math.max(right_max[i+1], height[i]);
        }

        int ans = 0;
        for(int i=1;i<n;i++){
            ans += Math.min(left_max[i],right_max[i]) - height[i];
        }

        return ans;

    }

}
