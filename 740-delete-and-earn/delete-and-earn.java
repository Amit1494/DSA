class Solution {
    public int[] convert(int arr[],int max){
        int res[]=new int[max+1];
        for(int i=0;i<arr.length;i++){
            res[arr[i]]+=arr[i];
        }
        return res;
    }
    public int deleteAndEarn(int[] arr) {
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        int res[]=convert(arr,max);
        return helper(res,res.length);
    }
    public int helper(int arr[],int n){
        if(n==1)return arr[1];
        int dp[]=new int[n+1];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            dp[i]=Math.max(dp[i-2]+arr[i],dp[i-1]);
        }
        return dp[n-1];
    }
}