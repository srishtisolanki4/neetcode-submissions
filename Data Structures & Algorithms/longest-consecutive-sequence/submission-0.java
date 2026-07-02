class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> set=new HashSet<>();
       for(int n:nums){
            set.add(n);
       }
       int length=0;

       for(int n:set){
            if(set.contains(n-1)){
                continue;
            }else{
                int s=n,len=1;
                while(set.contains(s+1)){
                    len++;
                    s++;
                }
                length=Math.max(len,length);
            }
       }
       return length;
       
    }
}
