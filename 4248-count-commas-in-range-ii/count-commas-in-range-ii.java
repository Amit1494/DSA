class Solution {
    public long countCommas(long n) {
        long commas=1;
        long lower=1000;
        long res=0;

        while(lower<=n){
            long upper=lower*1000-1;
            if(upper>n) upper=n;
            long count=upper-lower+1;
            res+=(count*commas);
            lower*=1000;
            commas++;
        }
        return res;
       

    }
}
