class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int n=points.length;
        int[][] ans=new int[k][2];

        for(int i=0;i<n;i++){
            int x=points[i][0];
            int y=points[i][1];
            int dist=(x*x + y*y);
            pq.add(new int[]{dist,x,y});
        }
        
        for(int i=0;i<k;i++){
            int[] point=pq.poll();
            ans[i]=new int[]{point[1],point[2]};
        }
        return ans;

    }
}
