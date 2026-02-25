class Solution {

    class Edge{
        int first;
        int second;
        Edge(int first,int second){
            this.first = first;
            this.second = second;
        }
    }

    class Pair{
        int first;
        int second;
        int third;

        Pair(int first,int second,int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }



      // note - in this Q standard Djistras will fail.
      // so we will judgement according to K here not dist.
      // and also here instead of PQ , simple Q will be used as we are increaing k by 1

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] a : flights){
            int from = a[0];
            int to = a[1];
            int cost = a[2];

            adj.get(from).add(new Edge(to,cost));
        }

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,src,0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int stops = curr.first;
            int node = curr.second;
            int cost = curr.third;
            
            if(stops > k) continue;

            for(Edge nbr:adj.get(node)){
                int adjNode = nbr.first;
                int wt = nbr.second;
                if(cost + wt < dist[adjNode]){
                    q.add(new Pair(stops+1,adjNode,cost+wt));
                    dist[adjNode] = cost + wt;
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}