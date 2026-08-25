class Solution {
    int dx[]={0,0,-1,1};
    int dy[]={-1,1,0,0};

    public void dfs(char [][]grid, int vis[][], int i, int j){
        vis[i][j]=1;

        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]=='1' && vis[x][y]==0){
                dfs(grid,vis,x,y);
            }
        }
        return;
        
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        int island=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    island+=1;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return island;
    }
}
