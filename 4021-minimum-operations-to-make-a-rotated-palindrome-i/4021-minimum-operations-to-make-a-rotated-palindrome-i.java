class Solution {
    public int minOperations(String s) {
        

        int mid=s.length()/2;
        int n=s.length()-1;
       
        int min=Integer.MAX_VALUE;
        int count=0;
        int rotations=0;
        for(int k=0;k<=n;k++)
        {
           count=0;
         String str=rotate(s,k);
         if(k!=0)
         {
          rotations++;
         }
        for(int i=0;i<mid;i++)
        {
            char ch=str.charAt(i);
            char ch1=str.charAt(n-i);
            int diff=Math.abs(ch-ch1);

            count+=Math.min(diff,26-diff);
           
        }
        count+=rotations;
        min=Math.min(min,count);
        }
        return min;
    }
    public String rotate(String s,int k)
    {

        k = k % s.length();

        String rotated = s.substring(k) + s.substring(0, k);

        return rotated;

    }
}