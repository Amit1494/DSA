class Solution {
    public boolean isMatch(String s, String p) {
        int ls=s.length()+1;
        int lp=p.length()+1;
        boolean [][]dp=new boolean[ls][lp];
        dp[0][0]=true;
        for(int j=1;j<lp;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }
        for(int i=1;i<ls;i++){
            for(int j=1;j<lp;j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1]||dp[i-1][j];
                }
                if(p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                if(p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[ls-1][lp-1];
        
    }
}