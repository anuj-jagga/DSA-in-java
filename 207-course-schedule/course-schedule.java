class Solution {
    // topo sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<Integer> topoSort = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[V];
        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++; // acc to Q
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            topoSort.add(node);
            for(int nbr:adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0) q.add(nbr);
            }
        }
        
        if(topoSort.size()==V) return true;
        return false;
    }
}