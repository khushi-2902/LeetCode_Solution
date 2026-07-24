class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
       for(int i=0;i<nums.length;i++)
       {
        totalSum+=nums[i];
       }
       if(totalSum%2!=0)
       {
           return false;
       }
       int target=totalSum/2;
      Boolean dp[][]=new Boolean[nums.length][target+1];
      int n=nums.length-1;
     return  solve(n,dp,nums,target);


    }
    public boolean solve(int n,Boolean dp[][],int nums[],int target)
    {
       if(target==0)
       {
        return true;
       }
       if(n<0)
       {
        return false;
          
       }

  if(dp[n][target]!=null)
  {
    return dp[n][target];
  }

        boolean include=false;
        if(nums[n]<=target)
        {
            include=solve(n-1,dp,nums,target-nums[n]);
        }
        boolean exclude=solve(n-1,dp,nums,target);
        return dp[n][target]=include || exclude;
        
    }
}