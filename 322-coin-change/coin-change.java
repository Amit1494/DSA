class Solution {
    public int coinChange(int[] coins, int amount) {
        // Define a large value to represent impossible states (infinity)
        final int INF = 1 << 30;
      
        // Get the number of coin types and target amount
        int numCoins = coins.length;
        int targetAmount = amount;
      
        // Create a 2D DP table
        // dp[i][j] represents the minimum number of coins needed to make amount j
        // using only the first i types of coins
        int[][] dp = new int[numCoins + 1][targetAmount + 1];
      
        // Initialize all states as impossible (infinity)
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
      
        // Base case: 0 coins needed to make amount 0
        dp[0][0] = 0;
      
        // Fill the DP table
        for (int i = 1; i <= numCoins; i++) {
            for (int j = 0; j <= targetAmount; j++) {
                // Option 1: Don't use the current coin type
                // Inherit the result from using only the first (i-1) coin types
                dp[i][j] = dp[i - 1][j];
              
                // Option 2: Use the current coin type if possible
                // Check if current amount j is at least as large as the coin value
                if (j >= coins[i - 1]) {
                    // Take minimum between not using current coin and using it
                    // When using current coin: add 1 to the count and reduce amount by coin value
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
      
        // Return the result
        // If the final value is still infinity, it means the amount cannot be formed
        return dp[numCoins][targetAmount] >= INF ? -1 : dp[numCoins][targetAmount];
    }
}
