import java.util.*;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                long sum = 0;
                visited[i][j] = true;
                stack.push(i * m + j);

                while (!stack.isEmpty()) {
                    int cell = stack.pop();
                    int r = cell / m;
                    int c = cell % m;

                    sum += grid[r][c];

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < n &&
                            nc >= 0 && nc < m &&
                            grid[nr][nc] != 0 &&
                            !visited[nr][nc]) {

                            visited[nr][nc] = true;
                            stack.push(nr * m + nc);
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
