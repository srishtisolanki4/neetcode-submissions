class Solution {
    Set<List<Integer>> ans; 
    public void helper(int[] nums, int i, int sum, List<Integer> temp){
        if(sum==0){
            ans.add(new ArrayList(temp));
            return;
        }
        
        for(int j=i;j<nums.length;j++){
            if(nums[j]>sum){
                break;
            }
            if(j>i && nums[j]==nums[j-1]){
                continue;
            }
            temp.add(nums[j]);
            helper(nums,j+1,sum-nums[j],temp);
            temp.remove(temp.size()-1);
        }
        
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans=new HashSet<>();
        Arrays.sort(candidates);
        helper(candidates,0,target,new ArrayList<>());
        return new ArrayList(ans);
    }
}
