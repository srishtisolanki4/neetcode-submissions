class Solution{

public boolean validTree(int n, int[][] edges) {
    int vis[] = new int[n];
    List<List<Integer>> adj = new ArrayList<>();
    
    for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
    }
    
    for (int edge[] : edges) {
        int u = edge[0];
        int v = edge[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    Queue<int[]> q = new LinkedList<>();
    
   
    q.add(new int[]{0, -1});
    while(!q.isEmpty()){
         int []polled=q.poll();
          int node=polled[0];
           int parent=polled[1]; 
           vis[node]=1;
            for(int neighbor:adj.get(node)){ 
                if(vis[neighbor]==0){
                    q.add(new int[]{neighbor,node}); } 
                else if(parent!=neighbor){
                    return false; }
            } 
    }
    for(int i=0;i<n;i++){
            if(vis[i]==0)return false;
        }
        
    
    return true;
        
        

  }
}

