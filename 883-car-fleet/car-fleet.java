class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] arr = new double[n][2];

        for(int i=0;i<n;i++){
            arr[i][0] = position[i];
            arr[i][1] = (double) (target - position[i])/speed[i]; // dist from target
        }

        Arrays.sort(arr,(a,b)-> Double.compare(a[0],b[0]));

        int fleet = 0;
        int i=n-1;
        while(i>=0){
            while(i!=0 && arr[i-1][1] <= arr[i][1]){
                arr[i-1][1] = arr[i][1];
                i--;
            }

            fleet++;
            i--;
        }
        return fleet;
    }
}