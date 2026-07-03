class Solution {
    public int maxArea(int[] heights) {
        int l=0,r=heights.length-1;
        int maxAmt=0;
        int water=0;
        while(l<r){
            water=(Math.min(heights[l],heights[r]))*(r-l);
            maxAmt=Math.max(maxAmt,water);
            if(heights[l]<heights[r]){l++;}
            else{r--;}
        }
        return maxAmt;
    }
}
