class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] arr = new double[n][2];

        for(int i=0;i<n;i++){
            arr[i][0] = position[i];
            arr[i][1] = (double) (target - position[i])/speed[i]; // dist from target
        }

        Arrays.sort(arr,(a,b)-> Double.compare(a[0],b[0]));

        int fleets = 0;
        double maxTime = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i][1] > maxTime) {
                fleets++;
                maxTime = arr[i][1];
            }
        }
        return fleets;
    }
}