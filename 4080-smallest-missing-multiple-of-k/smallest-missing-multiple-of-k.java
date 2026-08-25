class Solution {
    public int missingMultiple(int[] nums, int k) {
        int res=0;
        HashSet<Integer> hash=new HashSet();
        for(int i=0;i<nums.length;i++){
            hash.add(nums[i]);
        }
        for(int i=1;i<=101;i++){
                int n=i*k;
                if(!hash.contains(n)){
                    
                    return n;
                }
        }
        return -1;
        
    }
}