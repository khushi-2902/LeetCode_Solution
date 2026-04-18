class Solution {
    public int mirrorDistance(int n) {
        int number=n;
        int rev=0;
        while(number>0)
        {
            int digit=number%10;
            rev=rev*10+digit;
            number=number/10;
        }
        return Math.abs(n-rev);

    }
}