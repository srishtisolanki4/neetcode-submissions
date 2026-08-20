class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
                int h=heights[st.pop()];
                int w=st.isEmpty()?i:i-st.peek()-1;
                ans=Math.max(ans,h*w);
            }
            st.push(i);
        }
        return ans;
    }
}
