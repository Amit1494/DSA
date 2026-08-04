class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(max<nums[i]){
                max=nums[i];
            }
        }
        for(int i=1;i<nums.length;i++){
            if(min>nums[i]){
                min=nums[i];
            }
        }
        List<Integer> list=new ArrayList<>();

        Set<Integer> set=new HashSet<>();
        for(int i:nums){set.add(i);}
        for(int i=min;i<=max;i++){
            if(!(set.contains(i))){
                list.add(i);
            }
        }
        return list;

    }
}