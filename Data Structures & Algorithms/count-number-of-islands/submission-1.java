class Solution {
    int dx[]={0,0,-1,1};
    int dy[]={-1,1,0,0};

    public void dfs(char [][]grid,int i, int j){
        grid[i][j]='a';

        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]=='1'){
                dfs(grid,x,y);
            }
        }
        return;
        
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int island=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    island+=1;
                    dfs(grid,i,j);
                }
            }
        }
        return island;
    }
}
