class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2)return findMedianSortedArrays(nums2,nums1);

        int total=n1+n2;
        int half=(total+1)/2;
        int l=0;
        int r=n1;
        int mid1=0;
        int mid2=0;

        while(l<=r){
            mid1=l+(r-l)/2;
            mid2=half-mid1;

            int l1=(mid1>0)?nums1[mid1-1]:Integer.MIN_VALUE;
            int l2=(mid2>0)?nums2[mid2-1]:Integer.MIN_VALUE;
            int r1=(mid1<n1)?nums1[mid1]:Integer.MAX_VALUE;
            int r2=(mid2<n2)?nums2[mid2]:Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
                if(total%2==0){return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;}
                else return (double)Math.max(l1,l2);
            }else if(l1>r2){
                r=mid1-1;
            }else{
                l=mid1+1;
            }
        }
        return 0.0;

        
    }
}
