class Solution {
    public boolean divisorGame(int n) {
        return helper(n);
    }
    public boolean helper(int n){
        if(n<=0){
            return false;
        }
        for(int x=1;x<n;x++){
            if(n%x==0){
                return !helper(n-x);
            }
        }
        return false;
    }
}