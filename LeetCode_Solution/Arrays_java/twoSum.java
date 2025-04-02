class Solution
 {
    public int[] twoSum(int nums[], int target) {
         int arr2[][]=new int[nums.length][2];
        for(int i=0;i<nums.length;i++)
        {
           arr2[i][0]=nums[i];
           arr2[i][1]=i;
        }
        Arrays.sort(arr2, (a, b) -> Integer.compare(a[0], b[0]));
        int newarr[]=new int[2];
         int m=0;
         int n=nums.length-1;
         int i=0;
         while(m<n)
         {
            if(arr2[m][0]+arr2[n][0]==target)
            {
                newarr[i]=arr2[m][1];
                newarr[i+1]=arr2[n][1];
                return newarr;
            }
            else if(arr2[m][0]+arr2[n][0]>target)
            {
                n--;
            }
            else
            {
                m++;
            }
         }
         return null;
    }
 }

            
    
