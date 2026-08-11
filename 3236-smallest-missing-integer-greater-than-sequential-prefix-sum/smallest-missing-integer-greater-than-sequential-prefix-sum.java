class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
            for(int j=1;j<nums.length;j++){
                
                if(nums[j] ==( nums[j - 1] + 1)){
                    sum+=nums[j];
                }
                else{break;}
            }
        Set<Integer> hashset=new HashSet<>();
        for(int  i:nums)hashset.add(i);
        while(hashset.contains(sum)){
            sum++;
        }
        return sum;
    } 
}