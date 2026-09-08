class Solution {
    public int countCommas(int n) {
        int res=0;
        if(n<=999)return 0;
        if(n>=1000&&n<=10000){
            res=n-999;

        }
        if(n>=10000&&n<=100000){
            res=n-999;
            
        }
        return res;

    }
}