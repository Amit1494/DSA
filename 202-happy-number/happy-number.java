class Solution {
    public boolean isHappy(int n) {
        while(n>4){
            n=getNext(n);
        }
        if(n==1||n==7)
        {return true;}
        else{return false;}
    }
    private int getNext(int n){
        int total=0;
        while(n>0){
            int digit=n%10;
            total+=digit*digit;
            n/=10;

        }
        return total;
    }
}