class Solution {
    int[] dx={0,0,-1,1};
    int[] dy={1,-1,0,0};

    public boolean helper(char[][] board, String word, int i,int r, int c){
        if(i==word.length())return true;

        char temp=board[r][c];
        board[r][c]='#';
        
        for(int x=0;x<4;x++){
            int dr=r+dx[x];
            int dc=c+dy[x];

            if(dr>=0 && dr<board.length && dc>=0 && dc<board[0].length && board[dr][dc]==word.charAt(i)){
                if(helper(board,word,i+1,dr,dc))return true;
            }
        }
        board[r][c]=temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board,word,1,i,j))return true;
                }
            }
        }
        return false;
    }
}
