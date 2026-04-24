class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length+1][amount+1];
        int n=coins.length-1;
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        int ans=solve(coins,amount,dp,n);
        if(ans==Integer.MAX_VALUE)
        {
            return -1;
        }
       return ans;
    }
    public int solve(int coins[],int amount,int dp[][],int n)
    {
        //Base
        if(n==0)
        {
            if(amount%coins[0]==0)
            {
              return amount/coins[0];
            }
            else
            {
                return Integer.MAX_VALUE;
            }
        }


        if(dp[n][amount]!=-1)
        {
            return dp[n][amount];
        }
        int include=Integer.MAX_VALUE;
        if(coins[n]<=amount)
        {
            int res=solve(coins,amount-coins[n],dp,n);
            if(res!=Integer.MAX_VALUE)
            {
                include=1+res;
            }

        }
        int exclude=solve(coins,amount,dp,n-1);
        return dp[n][amount]=Math.min(include,exclude);
    }
}



//  public int coinChange(int[] coins, int amount) {

//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];

//         // Initialization: amount = 0
//         for (int i = 0; i < n; i++) {
//             dp[i][0] = 0;
//         }

        
//         for (int j = 1; j <= amount; j++) {
//             if (j % coins[0] == 0) {
//                 dp[0][j] = j / coins[0];
//             } else {
//                 dp[0][j] = amount + 1;
//             }
//         }

       
//         for (int i = 1; i < n; i++) {
//             for (int j = 1; j <= amount; j++) {

//                 int exclude = dp[i - 1][j];

//                 int include = amount + 1;
//                 if (coins[i] <= j) {
//                     include = 1 + dp[i][j - coins[i]];
//                 }

//                 dp[i][j] = Math.min(include, exclude);
//             }
//         }

//         int ans = dp[n - 1][amount];
//         return ans > amount ? -1 : ans;
//     }
// }