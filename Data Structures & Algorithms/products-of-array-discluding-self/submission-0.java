class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int fwd[]=new int[n];
        fwd[0]=1;
        int bwd[]=new int[n];
        bwd[n-1]=1;
        for(int i=0;i<n-1;i++){
            fwd[i+1]=fwd[i]*nums[i];
        }

        for(int i=n-1;i>0;i--){
            bwd[i-1]=bwd[i]*nums[i];
        }

        for(int i=0;i<n;i++){
            nums[i]=fwd[i]*bwd[i];
        }
        return nums;
    }
}  
