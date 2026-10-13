class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        long min=0;
        long max=0;
        for(int i=0;i<(nums.length/2);i++){
            min+=nums[i];
        }
        for(int i=(nums.length/2);i<nums.length;i++){
            max+=nums[i];
        }
        return max-min;
    }
}