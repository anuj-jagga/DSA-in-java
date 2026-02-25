class Solution {
     //We convert the problem into:
    // At each point on the road, how many passengers are inside?”
    // That’s exactly what prefix sum gives us.

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b) -> a[1]-b[1]);
        int n=trips.length;
        int[] stops = new int[1001];

        for(int[] trip : trips){
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            
            stops[start] += passengers; // +ve values
            stops[end] -= passengers; // -ve values
        }

        int currentPassengers = 0; // prefixSum
        for(int passengers : stops){
            currentPassengers += passengers;

            if(currentPassengers > capacity){
                return false;
            }
        }

        return true;
        
    }
}