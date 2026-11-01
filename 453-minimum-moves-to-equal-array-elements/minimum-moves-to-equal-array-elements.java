class Solution {
    public int minMoves(int[] nums) {
        int sum=0;
        int min=nums[0];
        for(int num:nums){
            if(num<min){
                min=num;
            }
            sum+=num;
        }
        return sum-(nums.length*min);
    }
}