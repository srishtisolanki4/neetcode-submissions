class Node{
    Node[] links=new Node[26];
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

    public void setFlag(){
        flag=true;
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root=new Node();
    }

    public void addWord(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node=node.get(ch);
        }
        node.setFlag();
    }

    public boolean search(String word) {
        Node node=root;
        return helper(word,node,0);
    }

    public boolean helper(String word, Node node, int ind){
        if(ind==word.length()){
            return node.flag;
        }

        char ch=word.charAt(ind);

        if(ch!='.'){
            if(node.containsKey(ch))return helper(word,node.get(ch),ind+1);
            else return false;
        }else{
            for(char c='a';c<='z';c++){
                if(node.containsKey(c)){
                    if(helper(word,node.get(c),ind+1))return true;
                }
            }
        }
        return false;

        
    }
}
