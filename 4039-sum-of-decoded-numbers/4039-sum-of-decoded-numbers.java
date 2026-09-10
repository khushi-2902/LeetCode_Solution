class Solution {
    public int sumDecoded(long[] nums) {
        long sum=0;
        for(int i=0;i<nums.length;i++)
        {

           
            long width=nums[i]%10;
            long d=nums[i]/10;
           
            //how to extract the width digits from d
           long digits = String.valueOf(d).length();

     long divisor = (long)Math.pow(10, digits - width);//i have to take the divisor of 10 to the power of the number(that is i m removing from d not the one that i want)

         long x = d / divisor;
         long y = d % divisor;

            long decoded=modPow(x,y,1000000007);
             sum=(sum+decoded)%1000000007;


        }
        return (int)sum;
    }
     private long modPow(long x, long y, long mod) {

        long result = 1;

        x %= mod;

        while (y > 0) {

            if (y % 2 == 1) {
                result = (result * x) % mod;
            }

            x = (x * x) % mod;

            y /= 2;
        }

        return result;
    }
}