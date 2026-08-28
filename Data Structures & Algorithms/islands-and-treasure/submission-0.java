class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=1;
                }
            }
        }
        int dx[]={0,0,-1,1};
        int dy[]={-1,1,0,0};

        while(!q.isEmpty()){
            int[] popped=q.poll();
            int i=popped[0];
            int j=popped[1];
            int curr_dist=popped[2];
            grid[i][j]=curr_dist;

            for(int k=0;k<4;k++){
                int x=i+dx[k];
                int y=j+dy[k];
                if(x>=0 && x<m && y>=0 && y<n && vis[x][y]==0 && grid[x][y]==2147483647){
                    q.add(new int[]{x,y,curr_dist+1});
                    vis[x][y]=1;
                }
            }
        }
        return;
    }
}
