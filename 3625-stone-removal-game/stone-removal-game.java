class Solution {
    public boolean canAliceWin(int n) {
       int count=0;
       int x=10;
       while(n>0){
        if(n>=x){
            n-=x;
            x--;
            count++;
        }
        else if(n<x)break;

       }
       if(count%2==0)return false;
       return true;
    }
}