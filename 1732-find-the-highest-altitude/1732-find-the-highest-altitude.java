class Solution {
    public int largestAltitude(int[] gain) {
        int leftDiff=0;
        int ans=0;
       
        for(int i=0;i<gain.length;i++)
        {
            leftDiff=leftDiff+gain[i];
             if(leftDiff>ans)
             {
                ans=leftDiff;
             }

        }
        return ans;
    }
}