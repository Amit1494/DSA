class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod=1000_000_007;
        int even=1;
        int odd=0;
        int prefix=0;
        for(int i=0;i<arr.length;i++){
            prefix+=arr[i];
            if(prefix%2==0){
                even++;
            }
            else{
                odd++;
            }
        }
        return (int)((1L*even*odd)%mod);
    }
}