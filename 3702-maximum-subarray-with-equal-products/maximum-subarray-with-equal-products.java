class Solution {
    public long gcd(long a, long b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

public long callcm(long a, long b) {
    return (a / gcd(a, b)) * b;
}
    public int maxLength(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            double product =0.0;
            long gcdd=nums[i];
            long lcmm=nums[i];
            for(int j=i;j<nums.length;j++){
                product +=Math.log(nums[j]);
                gcdd=gcd(gcdd,nums[j]);
                lcmm=callcm(lcmm,nums[j]);
                if(Math.abs(product - (Math.log(lcmm) + Math.log(gcdd))) < 1e-9){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
  

        return ans;

    }
    
}