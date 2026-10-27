class Solution {
    public int trap(int[] height) {
        int n=height.length;
        
        int pref[]=new int[n];
        pref[0]=height[0];
        int suff[]=new int[n];
        for(int i=1;i<n;i++){
            pref[i]=Math.max(pref[i-1],height[i]);
        }
        suff[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]=Math.max(height[i],suff[i+1]);
        }

        int total=0;
        int left=0;
        int right=0;
        for(int i=0;i<n-1;i++){
            left=pref[i];
            right=suff[i];
            if(height[i]<left && height[i]<right){
                total+=Math.min(left,right)-height[i];
            }
        }
        return total;
    }
}