class Solution {
    public void dfs(int node, List<List<Integer>> adj, int []vis){
        vis[node]=1;

        for(int neighbor:adj.get(node)){
            if(vis[neighbor]==0){
                dfs(neighbor,adj,vis);
            }
        }
        return;
    }
    public int countComponents(int n, int[][] edges) {
        int vis[]=new int[n];
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,adj,vis);
            }
        }
        return cnt;
    }
}
