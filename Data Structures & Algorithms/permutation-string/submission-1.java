class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int l=0;
        int r=0;
        int n=s2.length();

        while(r<n){
            char right=s2.charAt(r);
            if(map.containsKey(right))
            {
                map.put(right,map.get(right)-1);
                while(map.get(right)<0){
                    char left=s2.charAt(l);
                    if(map.containsKey(left)){
                        map.put(left,map.get(left)+1);
                    }
                    l++;
                }
                if (r - l + 1 == s1.length()) return true;
            } else {
                while(l < r){
                    char left=s2.charAt(l);
                    if(map.containsKey(left)){
                        map.put(left,map.get(left)+1);
                    }
                    l++;
                }
                l = r + 1;
            }
            r++;
        }
        
        return false;
    }
}
