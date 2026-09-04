class Solution {
    class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            parent=new int[n];
            rank=new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        public int find(int node){
            int curr=node;
            while(curr!=parent[curr]){
                parent[curr]=parent[parent[curr]];
                curr=parent[curr];
            }
            return curr;
        }

        public boolean union(int u, int v){
            int pu=find(u);
            int pv=find(v);
            if(pu==pv)return false;
            if(rank[pv]>rank[pu]){
                int temp=pv;
                pv=pu;
                pu=temp;
            }
            parent[pv]=pu;
            rank[pu]+=rank[pv];
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu=new DSU(edges.length+1);
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            if(!dsu.union(u,v))return edge;

        }return new int[0];
    }
}