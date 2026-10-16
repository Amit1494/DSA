class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> slidingWindow=new TreeSet<>();
        for(int ci=0;ci<nums.length;ci++){
            Long cv=slidingWindow.ceiling((long) nums[ci]-(long) valueDiff);
            if(cv!=null && cv<=(long) nums[ci]+(long)valueDiff){
                return true;
            }
            slidingWindow.add((long) nums[ci]);
            if(ci>=indexDiff){
                slidingWindow.remove((long)nums[ci-indexDiff]);
            }
        }
        return false;
        
    }
}