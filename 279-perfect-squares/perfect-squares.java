class Solution {
    public int numSquares(int n) {
        Arrays.fill(arr,-1);
        return helper(n);
    }
    int arr[]=new int[10001];
    public int helper(int n){
        if(n==0){
            return 0;

        }
        if(arr[n]!=-1)return arr[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
           
            int res=1+helper(n-i*i);
            min=Math.min(res,min);
        }
        arr[n]=min;
        return min;
    }
}