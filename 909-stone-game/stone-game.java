class Solution {
    public boolean stoneGame(int[] piles) {
        
        int total=0;
        int dp[][]=new int[piles.length][piles.length];
        for(int row[]:dp)Arrays.fill(row,-1);
        for(int i:piles){total+=i;}
        int i=helper(0,piles.length-1,piles,dp);
        int j=total-i;
        if(i>j)return true;
        return false;

    }
    public int helper(int i,int j,int piles[],int dp[][]){
        if(i>j)return 0;
        
        if(dp[i][j]!=-1)return dp[i][j];
        
        int takei=piles[i]+Math.min(helper(i+2,j,piles,dp),helper(i+1,j-1,piles,dp));
        int takej=piles[j]+Math.min(helper(i+1,j-1,piles,dp),helper(i,j-2,piles,dp));
        return dp[i][j]=Math.max(takei,takej);

    }
}