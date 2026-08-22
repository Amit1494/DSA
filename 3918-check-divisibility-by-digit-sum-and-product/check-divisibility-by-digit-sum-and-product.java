class Solution {
    public boolean checkDivisibility(int n) {
        if(n<10)return false;
        int res=digits(n)+product(n);
        if(n%res==0)return true;
        return false;
    }
    int digits(int n){
        int sum=0;
        while(n>0){
            int rem=n%10;
            sum+=rem;
            n/=10;
        }
        return sum;
    }
    int product(int n){
        int sum=1;
        while(n>0){
            int rem=n%10;
            sum*=rem;
            n/=10;
        }
        return sum;

    }
}