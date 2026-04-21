class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int leftMax=nums[0];
        int rightMin[]=new int[nums.length];
        rightMin[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
            rightMin[i]=Math.min(nums[i],rightMin[i+1]);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(i!=0 && nums[i]>leftMax)
            {
              leftMax=nums[i];

            }
            int instability=leftMax-rightMin[i];
            if(instability<=k)
            {
                return i;
            }
            
        }
        return -1;
    }
}