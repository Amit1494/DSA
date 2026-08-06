class Solution {
    public int smallestNumber(int n, int t) {
        int ans=n;
        for(int i=n;i<n+10;i++){
            int k=product(n++);
            if(k%t==0){
                ans=i;
                break;
            }
            
        }
        return ans;
    }
    public int product(int n){
        int res=1;
        while(n!=0){
            int temp=n%10;
            res*=temp;
            n/=10;
        }
        return res;
    }
}