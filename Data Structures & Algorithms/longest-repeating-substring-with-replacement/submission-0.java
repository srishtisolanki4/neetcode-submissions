class Solution {
    public int characterReplacement(String s, int k) {
        int freq[]=new int[26];
        int l=0;
        int r=0;
        int n=s.length();
        int maxF=0;
        int ans=0;

        while(l<=r && r<n){
            char ch=s.charAt(r);
            freq[ch-'A']++;
            maxF=Math.max(maxF,freq[ch-'A']);
            while((r-l+1)-maxF>k){
                char left=s.charAt(l);
                freq[left-'A']--;
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;

        }
        return ans;
    }
}
