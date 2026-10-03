class Node{
    Node[] links= new Node[26];
    boolean flag=false;

    public Node(){}

    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    public void put(char ch, Node node){
        links[ch-'a']=node;
    }

    public Node get(char ch){
        return links[ch-'a'];
    }

    public void setEnd(){
        flag=true;
    }

    public boolean isEnd(){
        return flag;
    }
}
class PrefixTree {
    private static Node root;
    public PrefixTree() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node=node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node=root;
        for(char ch: word.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node=node.get(ch);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node=root;
        for(char ch:prefix.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node=node.get(ch);
        }
        return true;
    }
}

