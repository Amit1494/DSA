class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less=0;
        int tar=0;
        for(int i:nums){
            if(i<target)less++;
            else if(target==i){tar++;}
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<tar;i++){
            list.add(less+i);
        }
        return list;
    }
}