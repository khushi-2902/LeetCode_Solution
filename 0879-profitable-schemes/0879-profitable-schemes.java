class Solution {
   
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int dp[][][]=new int[group.length][n+1][minProfit+1];
         for (int i = 0; i < group.length; i++) {
              for (int j = 0; j <=n; j++) {
                 Arrays.fill(dp[i][j], -1);
              }
         }
        int  ans=solve(group.length-1,n,minProfit,group,profit,0,0,dp);
        return ans;
    }
    public int  solve(int n,int m,int minProfit,int group[],int profit[],int members,int p,int dp[][][])
    {
        //BaseCase
          if(n < 0)
        {
          return (p >= minProfit) ? 1 : 0;
        }
        if(dp[n][members][p]!=-1)
        {
            return dp[n][members][p];
        }

        int include=0;
        if(members+group[n]<=m)
        {
            int newProfit=Math.min(p+profit[n],minProfit);
            include=solve(n-1,m,minProfit,group,profit,members+group[n],newProfit,dp);
        }
        int exclude=solve(n-1,m,minProfit,group,profit,members,p,dp);
        return dp[n][members][p]=(include+exclude)%1000000007;
    }
}