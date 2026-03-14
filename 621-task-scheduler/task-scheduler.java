class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c:tasks){
            freq[c-'A']++;
        }
        
        Arrays.sort(freq); //
        int holes = freq[25]-1;
        int slots = holes*n;

        for(int i=24;i>=0;i--){
            if(slots <= 0) return tasks.length;
            slots -= Math.min(freq[i],holes); //
        }

        return tasks.length + slots;
    }
}