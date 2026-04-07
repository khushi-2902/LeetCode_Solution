class Solution {
    int MOD = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int dp[][][] = new int[group.length][n + 1][minProfit + 1];

        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        } return solve(group.length - 1, n, minProfit, group, profit, 0, 0, dp);
    }

    public int solve(int idx, int n, int minProfit, int[] group, int[] profit, int members, int currProfit, int[][][] dp) {
        if (idx < 0) {
            return currProfit >= minProfit ? 1 : 0;
        }

        if (dp[idx][members][currProfit] != -1) {
            return dp[idx][members][currProfit];
        }

        int include = 0;
        if (members + group[idx] <= n) {
            int newProfit = Math.min(currProfit + profit[idx], minProfit);
            include = solve(idx - 1, n, minProfit, group, profit, members + group[idx], newProfit, dp);
        }
    int exclude = solve(idx - 1, n, minProfit, group, profit, members, currProfit, dp);

        return dp[idx][members][currProfit] = (include + exclude) % MOD;
    }
}