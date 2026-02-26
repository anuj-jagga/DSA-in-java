class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int costSum = 0;
        for(int c:cost) costSum+=c;
        int gasSum = 0;
        for(int g:gas) gasSum+=g;
        if(costSum > gasSum) return -1;

        int sum = 0;
        int idx = 0;

        for(int i=0;i<gas.length;i++){
            sum += gas[i];
            sum -= cost[i];

            if(sum < 0){
                sum = 0;
                idx = i+1;
            }
        }

        return idx<gas.length? idx : -1;
    }
}