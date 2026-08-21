class Solution {
    public long calc(int nums[], int m){
        long h=0L;
        for(int num:nums){
            h+=(num+m-1L)/m;
        }
        return h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=0;
        for(int pile:piles){
            if(pile>r){
                r=pile;
            }
        }
        while(l<=r){
            int mid=(l+r)/2;
            long hours=calc(piles,mid);
            if(hours<=h){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
