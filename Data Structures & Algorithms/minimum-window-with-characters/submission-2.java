class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        if (t.isEmpty()) return "";
        Map<Character,Integer> freq=new HashMap<>();
        Map<Character,Integer> window=new HashMap<>();
        
        for(char ch:t.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }

        int n=freq.size();
        int cnt=0;
        int minLen=Integer.MAX_VALUE;
        int[] res={-1,-1};

        int l=0;

        for(int r=0;r<s.length();r++){
            char right=s.charAt(r);
            window.put(right,window.getOrDefault(right,0)+1);

            if(freq.containsKey(right) && freq.get(right).equals(window.get(right))){
                cnt++;
            }

            while(cnt==n){
                if((r-l+1)<minLen){
                    minLen=r-l+1;
                    res[0]=l;
                    res[1]=r;
                }

                char left=s.charAt(l);
                window.put(left,window.get(left)-1);
                if(freq.containsKey(left) && freq.get(left)>window.get(left)){
                    cnt--;
                }
                l++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);

    }
}
