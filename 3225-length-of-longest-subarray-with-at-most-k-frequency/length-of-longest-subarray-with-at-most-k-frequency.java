class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        int j=0;
        int i=0;
        int result=0;
        while(j<nums.length){
            hash.put(nums[j],hash.getOrDefault(nums[j],0)+1);
            while(hash.get(nums[j])>k){
                hash.put(nums[i],hash.get(nums[i])-1);
                i++;
            }
            result=Math.max(result,j-i+1);
            j++;
        }
        return result;

    }
}