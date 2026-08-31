class Solution {
    int directions[][]={{0,-1} , {-1,0}, {1,0}, {0,1}};
    public void dfs(int r, int c, boolean[][] ocean, int [][] heights){
        ocean[r][c]=true;

        for(int dir[]:directions){
            int x=r+dir[0];
            int y=c+dir[1];

            if(x>=0 && x<heights.length && y>=0 && y<heights[0].length && !ocean[x][y] && heights[x][y]>=heights[r][c]){
                dfs(x,y,ocean,heights);
            }
        }
        return;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean [][] pac=new boolean[m][n];
        boolean [][] atlantic=new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(i,0,pac,heights);
            dfs(i,n-1,atlantic,heights);
        }

        for(int j=0;j<n;j++){
            dfs(0,j,pac,heights);
            dfs(m-1,j,atlantic,heights);
        }

        List<List<Integer>> list=new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j] && atlantic[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        
        }
        return list;

        
    }
}