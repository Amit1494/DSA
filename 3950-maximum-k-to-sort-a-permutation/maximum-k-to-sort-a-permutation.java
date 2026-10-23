class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int k=(1<<21)-1 ;
        boolean flag=true;
        for(int i=0;i<n;i++){
            if(nums[i]!=i){
                k&=nums[i];
                flag=false;
            }
        }
        if(flag){
            return 0;
        } 
        return k;

    }
}