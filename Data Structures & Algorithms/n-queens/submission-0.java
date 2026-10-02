class Solution {
    List<List<String>> ans;
    public boolean canPlace(int row, int col, char[][]board, int n){

        //1-col check
        for(int r=0;r<row;r++){
            if(board[r][col]=='Q')return false;
        }

        //2-left diagonal
        int r=row-1;
        int c=col-1;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q')return false;
            r--;
            c--;
        }

        //3-right diagonal
        r=row-1;
        c=col+1;
        while(r>=0 && c<n){
            if(board[r][c]=='Q')return false;
            r--;
            c++;
        }
        return true;

    }
    public void helper(int n, char[][]board, int row){
        if(row==n){
            List<String> copy = new ArrayList<>();
            for (char[] r: board) {
                copy.add(new String(r));
            }
            ans.add(copy);
            return;
        }

        for(int c=0;c<n;c++){
            if(canPlace(row,c,board,n)){
                board[row][c]='Q';
                helper(n,board,row+1);
                board[row][c]='.';
            }
        }
        return;
    }
    public List<List<String>> solveNQueens(int n) {
        ans=new ArrayList<>();
        
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        helper(n,board,0);
        return ans;
    }
}
