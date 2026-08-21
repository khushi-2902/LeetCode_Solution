class Solution {
    public void nextPermutation(int[] nums) {
        int smallestAfterPivot=-1;
    
        int pivot=-1;
        for(int i=nums.length-2;i>=0;i--)
        {
           if(nums[i]<nums[i+1])
           {
            pivot=i;
            break;
           }
           
        }
        if(pivot==-1)
        {
            reverse(0,nums.length-1,nums);
            return;
        }
            int smallest=Integer.MAX_VALUE;
        for(int i=pivot+1;i<nums.length;i++)
        {
            if(nums[i]<=smallest && nums[i]>nums[pivot])
            {
                smallest=Math.min(smallest,nums[i]);
                smallestAfterPivot=i;
                
            }
        }
        int temp=nums[pivot];
        nums[pivot]=nums[smallestAfterPivot];
        nums[smallestAfterPivot]=temp;
         reverse(pivot+1,nums.length-1,nums);
        
    }
    public void reverse(int i,int j,int nums[])

    {
       
       
        while(i<j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;

        }

    }
}