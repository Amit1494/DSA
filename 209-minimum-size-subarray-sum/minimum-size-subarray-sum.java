class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int current=0;
        int low=0;
        int high=0;
        while(high<nums.length){
            current+=nums[high];
            high++;
            while(current>=target){
                int currentwindow=high-low;
                min=Math.min(min,currentwindow);
                current-=nums[low];
                low++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;


       }
}