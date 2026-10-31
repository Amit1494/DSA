
class Solution {
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = 1_000_000_007;

        int[][] right = new int[n][m];
        int[][] down = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int id = i * m + j;

                if (grid[i][j] == 0) {
                    right[i][j] = id;
                    down[i][j] = id;
                } else {
                    right[i][j] =
                        (i + 1 < n) ? down[i + 1][j] : -1;

                    down[i][j] =
                        (j + 1 < m) ? right[i][j + 1] : -1;
                }
            }
        }

        long[][] dp = new long[n][m];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == 0) continue;

                // Move right
                if (j + 1 < m) {
                    int dest = right[i][j + 1];

                    if (dest != -1) {
                        int r = dest / m;
                        int c = dest % m;

                        dp[r][c] =
                            (dp[r][c] + dp[i][j]) % MOD;
                    }
                }

                // Move down
                if (i + 1 < n) {
                    int dest = down[i + 1][j];

                    if (dest != -1) {
                        int r = dest / m;
                        int c = dest % m;

                        dp[r][c] =
                            (dp[r][c] + dp[i][j]) % MOD;
                    }
                }
            }
        }

        return (int) dp[n - 1][m - 1];
    }
}
