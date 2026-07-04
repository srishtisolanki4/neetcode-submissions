class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character,Integer> map= new HashMap<>();
       int length=0;
       int l=0,r=0;
       while(l<=r && r<s.length()){
            char ch=s.charAt(r);
            if(map.containsKey(ch)){
                l=Math.max(l,map.get(ch)+1);
            }
            map.put(ch,r);
            length=Math.max(length,r-l+1);
            r++;
       }
       return length;
        
    }
}
