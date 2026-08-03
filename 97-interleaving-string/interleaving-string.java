class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())return false;
        Boolean[][] dp=new Boolean[s1.length()+1][s2.length()+1];
        
        return solve(s1,s2,s3,0,0,dp);
    }
    public boolean solve(String s1,String s2,String s3,int i,int j,Boolean[][] dp){
        boolean ans=false;
        if(i>=s1.length() && j>=s2.length()){
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(i<s1.length()){
        if(s1.charAt(i)==s3.charAt(i+j)){
            ans=ans||solve(s1,s2,s3,i+1,j,dp);
            
        }}
        if(j<s2.length()){
        if(s2.charAt(j)==s3.charAt(j+i)){
            ans=ans||solve(s1,s2,s3,i,j+1,dp);
            
        }}
        return dp[i][j]=ans;
        
       
    }
}