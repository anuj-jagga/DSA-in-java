class LRUCache {
    class Node{
        int key,val;
        Node prev,next;

        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    
    int n;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1); // dummys
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        n = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value; // update value in map
            remove(node);
            insert(node);
            return;
        }

        if(map.size() == n){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key); // this is the reason we store key in Node so when removing LRU from DLL, we can also delete it from HashMap in 
            //O(1)
        }

        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);
    }

    void insert(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */