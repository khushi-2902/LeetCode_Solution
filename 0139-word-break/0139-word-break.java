class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);

        Boolean[] dp = new Boolean[s.length()];

        return solve(0, s, set, dp);
    }

    public boolean solve(int start,
                         String s,
                         HashSet<String> set,
                         Boolean[] dp) {

        if (start == s.length()) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        StringBuilder curr = new StringBuilder();

        for (int i = start; i < s.length(); i++) {

            curr.append(s.charAt(i));

            if (set.contains(curr.toString())) {

                if (solve(i + 1, s, set, dp)) {
                    return dp[start] = true;
                }
            }
        }

        return dp[start] = false;
    }
}