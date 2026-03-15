class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // PriorityQueue<int[]> maxHeap =  new PriorityQueue<> ((a,b)-> (int)((Math.pow(b[0],2) + Math.pow(b[1],2)) - (Math.pow(a[0],2) + Math.pow(a[1],2))));

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distB, distA);
        });

        for(int[] a : points){
            maxHeap.add(new int[]{a[0],a[1]}); 
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        
        for(int i=0; i<k; i++){
            int[] a = maxHeap.poll();
            res[i][0] = a[0];
            res[i][1] = a[1];
        }

        return res;
    }
}