/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node cloneNode = new Node(node.val);
        map.put(node,cloneNode);
        dfs(node, cloneNode);
        return cloneNode;
    }

    void dfs(Node orgNode, Node cloneNode){
        for(Node nbr:orgNode.neighbors){
            if(map.containsKey(nbr)){
                Node nbrClone = map.get(nbr);
                cloneNode.neighbors.add(nbrClone);
            }
            else{
                Node nbrClone = new Node(nbr.val);
                map.put(nbr,nbrClone);
                cloneNode.neighbors.add(nbrClone);
                dfs(nbr,nbrClone);
            }
        }
    }
}