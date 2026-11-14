class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min=Integer.MAX_VALUE;
        int n=nums.size();
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n && (j-i+1<=r);j++){
                sum+=nums.get(j);
                if(j-i+1>=l && sum>0){
                    min=Math.min(min,sum);
                }
            }
        }
        if(min==Integer.MAX_VALUE)return -1;
        return min;
    }
}