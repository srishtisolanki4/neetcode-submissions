class Solution {
    public int maxSubArray(int[] nums) {
        int s=0;
        int maxSum=Integer.MIN_VALUE;
        for(int num:nums){
            s+=num;
            maxSum=Math.max(s,maxSum);
            if(s<0)s=0;
        }
        return maxSum;
    }
}
