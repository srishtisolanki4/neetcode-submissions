class Solution {
    Set<List<Integer>> ans;
    public void helper(int[] nums, int i, List<Integer> temp){
        if(i==nums.length){
           
            ans.add(new ArrayList(temp));
            return;
        }
        temp.add(nums[i]);
        helper(nums,i+1,temp);
        temp.remove(temp.size()-1);
        helper(nums,i+1,temp);
        return;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans=new HashSet<>();
        helper(nums,0,new ArrayList<>());
        return new ArrayList(ans);
    }
}
