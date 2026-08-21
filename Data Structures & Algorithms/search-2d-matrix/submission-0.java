class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int start=0;
        int end=(m*n)-1;
        int mid=0;
        int r=0;
        int c=0;
        while(start<=end){
            mid=(end+start)/2;
            r=mid/n;
            c=mid%n;
            if(matrix[r][c]<target){
                start=mid+1;
            }else if(matrix[r][c]==target){
                return true;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
}
