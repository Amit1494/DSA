class Solution {
    public int minimizeSum(int[] nums) {
    Arrays.sort(nums);
    int n=nums.length;
    int ans=Math.min(nums[n-3]-nums[0],
    nums[n-1]-nums[2]);
    return Math.min(
    ans,nums[n-2]-nums[1]
    );
        
        
    }
    
}