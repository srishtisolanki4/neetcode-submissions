class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
    }

}
class LRUCache {
    HashMap<Integer,Node> map;
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        cap=capacity;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==cap){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }

    public void insert(Node node){
        map.put(node.key,node);
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}
