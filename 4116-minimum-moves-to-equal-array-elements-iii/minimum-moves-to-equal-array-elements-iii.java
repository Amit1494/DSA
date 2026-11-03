class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(max<nums[i]) max=nums[i];
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=(max-nums[i]);
        }
        return sum;
    }
}