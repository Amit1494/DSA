class Solution {
    public int helper(int cost[],int n){
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=Math.min(cost[1],cost[0]);
        for(int i=3;i<=n;i++){
            dp[i]=Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
        }
        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        
        return helper(cost,cost.length);
    }
}