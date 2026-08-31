class Solution {
    int dx[]={0,0,-1,1};
    int dy[]={-1,1,0,0};
    public void dfs(char[][]board, int i, int j, int m, int n){
        board[i][j]='#';
        
        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0 && x<m && y>=0 && y<n &&  board[x][y]=='O'){
                    dfs(board,x,y,m,n);
            }
        }
        return;
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j]=='O'){
                    dfs(board,i,j,m,n);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
        return;
    }
}
