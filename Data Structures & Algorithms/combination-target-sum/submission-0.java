class Solution {
    List<List<Integer>> ans;
    public void helper(int[] nums, int ind, int sum,List<Integer> temp){
        if(sum<0)return;
        if(sum==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(ind==nums.length){
            return;
        }

        temp.add(nums[ind]);
        helper(nums,ind,sum-nums[ind],temp);
        temp.remove(temp.size()-1);
        helper(nums,ind+1,sum,temp);
        return;
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(nums,0,target,temp);
        return ans;
    }
}
