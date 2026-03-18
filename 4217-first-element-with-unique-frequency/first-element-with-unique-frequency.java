class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        HashMap<Integer,Integer> freqCnt = new HashMap<>();
        for(int v:map.values()){
            freqCnt.put(v,freqCnt.getOrDefault(v,0)+1);
        }

        for(int num : nums){
            if(freqCnt.get(map.get(num)) == 1) return num;
        }
        return -1;
    }
}