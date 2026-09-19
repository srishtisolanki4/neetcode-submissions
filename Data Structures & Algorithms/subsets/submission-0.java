class Solution {
    List<List<Integer>> ans;
    public void helper(int[] nums, List<Integer> temp, int idx){
        if(nums.length==idx){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        helper(nums,temp,idx+1);
        temp.remove(temp.size()-1);
        helper(nums,temp,idx+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(nums,temp,0);
        return ans;
    }
}
