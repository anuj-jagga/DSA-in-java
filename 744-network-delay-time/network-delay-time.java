class Solution {
    class Pair{
        int node,dist;
        Pair(int node,int wt){
            this.node = node;
            dist = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[]a : times){
            int u = a[0];
            int v = a[1];
            int wt = a[2];
            adj.get(u).add(new Pair(v,wt));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dist - b.dist);
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            if(curr.dist > dist[node]) continue;

            for(Pair nbr : adj.get(node)){
                int nbrNode = nbr.node;
                int wt = nbr.dist;
                if(dist[node]+wt < dist[nbrNode]){
                    dist[nbrNode] = dist[node]+wt;
                    pq.add(new Pair(nbrNode,dist[nbrNode]));
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i] == (int)1e9) return -1;
            ans = Math.max(dist[i],ans);
        }
        return ans;
    }
}