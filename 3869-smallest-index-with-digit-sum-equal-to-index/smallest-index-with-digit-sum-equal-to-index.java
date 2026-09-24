class Solution {
    public int smallestIndex(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(helper(i,nums[i])){
                return i;
            }
        }

        return -1;
    }
    public boolean helper(int i,int n){
        int sum=0;
        while(n!=0){
            int temp=n%10;
            sum+=temp;
            n/=10;
        }
        return sum==i;
    }
}