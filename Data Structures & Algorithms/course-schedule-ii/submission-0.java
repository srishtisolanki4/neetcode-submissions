class Solution {
    ArrayList<Integer> ans;
    public boolean check(int node, int vis[],List<List<Integer>> adj){
        vis[node]=1;
        for(int neighbor:adj.get(node)){
            if(vis[neighbor]==1)return true;
            if(vis[neighbor]==0){
                if(check(neighbor,vis,adj))return true;}
        }
        vis[node]=2;
        ans.add(node);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ans=new ArrayList<>();
        int vis[]=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[]:prerequisites){
            int u=edge[0];
            int v=edge[1];
            adj.get(v).add(u);
        }

        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(check(i,vis,adj))return new int[0];
            }
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}