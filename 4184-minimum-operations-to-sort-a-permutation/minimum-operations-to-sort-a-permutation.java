class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int asc=0;
        int dsc=0;
        for(int i=0;i<n;i++){
            int next=(i+1)%n;
            if(nums[next]==(nums[i]+1)%n)asc++;
            if(nums[next]==(nums[i]-1+n)%n)dsc++;
        }
        if(asc==n){
            if(nums[0]==0)return 0;
            int k=nums[0];
            return Math.min(n-k,k+2);

        }
        if(dsc==n)
        {
            int k=nums[0]==n-1?0:n-nums[0]-1;
            return Math.min(k+1,n-k+1);
        }
        return -1;
    }
}