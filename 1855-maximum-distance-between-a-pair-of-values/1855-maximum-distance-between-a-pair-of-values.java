class Solution {
    public int maxDistance(int[] nums1, int[] nums2){
        
        int max=0;
        for(int i=0;i<nums1.length;i++)
        {
            int start=i;
        int end=nums2.length-1;
            int ans=-1;
            while(start<=end)
            {
                int mid=(start+end)/2;
                if(nums2[mid]>=nums1[i])
                {
                    ans=mid;
                    start=mid+1;
                }
                else
                {
                    end=mid-1;
                }

            }
            int dist=ans-i;
            max=Math.max(max,dist);
        }
        return max;

    }
}