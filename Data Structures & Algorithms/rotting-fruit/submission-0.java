class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        int minutes=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int dx[]={0,0,-1,1};
        int dy[]={-1,1,0,0};

        while(fresh>0 && !q.isEmpty()){
            int len=q.size();
            for(int z=0;z<len;z++){
                int []polled=q.poll();
                int i=polled[0];
                int j=polled[1];
                for(int k=0;k<4;k++){
                    int x=i+dx[k];
                    int y=j+dy[k];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        fresh--;
                        grid[x][y]=2;
                        q.add(new int[]{x,y});
                    }
                }
            }
            minutes++;
        }
        return (fresh==0)?minutes:-1;
    }
}
