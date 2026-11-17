class Solution {
    public int minimumChanges(String s, int k) {
        int n=s.length();
        int [][]dp=new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][0]=0;
        
        int[][] cost = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i+2;j<=n;j++){
                String sub=s.substring(i,j);
                int changes=calculateCost(sub);
                cost[i][j-1]=changes;
            }
        }
        for (int j = 1; j <= k; j++) {
    for (int i = 2 * j; i <= n; i++) {

        for (int p = 2 * (j - 1); p <= i - 2; p++) {

            if (dp[p][j - 1] == Integer.MAX_VALUE) {
                continue;
            }

            dp[i][j] = Math.min(
                dp[i][j],
                dp[p][j - 1] + cost[p][i - 1]
            );
        }
    }
}

return dp[n][k];
        
    }
    public int calculateCost(String sub){
        ArrayList<Integer> list=new ArrayList<>();
        int n=sub.length();
        for(int i=1;i<n;i++){
            if(n%i==0){
                list.add(i);
            }
        }
        int minchanges=Integer.MAX_VALUE;
        for(int d:list){
            int changes=calculate(sub,d);
            minchanges=Math.min(minchanges,changes);
        }
        return minchanges;
    }
    public int calculate(String sub,int d){
        int changes=0;
        int len=sub.length();
        int gl=len/d;
        for(int i=0;i<d;i++ ){
            int left=i;
            int right=i+(gl-1)*d;
            while(left<right){
                if(sub.charAt(left)!=sub.charAt(right)){
                    changes++;
                }
                left+=d;
                right-=d;
            }
        }
        return changes;
    }
}