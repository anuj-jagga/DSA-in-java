class Solution {
    int MOD = (int) 1e9+7;
    class Pair{
        int v;
        long wt;

        Pair(int v,long wt){
            this.v = v;
            this.wt = wt;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e:roads){
            adj.get(e[0]).add(new Pair(e[1],e[2]));
            adj.get(e[1]).add(new Pair(e[0],e[2]));

        }

        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> Long.compare(a.wt,b.wt));
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.v;
            long d = curr.wt;

            if(d > dist[node]) continue;

            for(Pair edge:adj.get(node)){
                int nbr = edge.v;
                long wt = edge.wt;

                if(dist[node] + wt < dist[nbr]){
                    dist[nbr] = dist[node] + wt;
                    pq.add(new Pair(nbr,dist[nbr]));
                    ways[nbr] = ways[node];
                }
                else if(dist[node] + wt == dist[nbr]){
                    ways[nbr] = (ways[nbr] + ways[node]) % MOD;
                }
            }
        }

        return ways[n-1];
    }
}