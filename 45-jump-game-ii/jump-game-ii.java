class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length+1];
        
            Arrays.fill(dp,-1);
        
        return helper(0,nums,dp);
    }
    public int helper(int ind,int arr[],int dp[]){

        if(ind>=arr.length-1)return 0;
        if(dp[ind]!=-1)return dp[ind];
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<=arr[ind];i++){
            if(ind+1<arr.length){
                int jumps=helper(ind+i,arr,dp);
                if(jumps!=Integer.MAX_VALUE){
                    mini=Math.min(mini,1+jumps);
                }
            }
        }
        return dp[ind]=mini;
    }
}