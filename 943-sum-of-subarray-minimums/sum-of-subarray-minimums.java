class Solution {
    public int sumSubarrayMins(int[] arr) {
        int pse[]=pse(arr);
        int nse[]=nse(arr);
        long total=0;
        
        int MOD = 1_000_000_007;
        for(int i=0;i<arr.length;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            long contribution=((long)left*right)%MOD;
            contribution=(contribution*arr[i])%MOD;
            total=(total+contribution)%MOD;
        }
        return (int)total;
    }
    public int[] nse(int []arr){
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();

            }
            if(!stack.isEmpty()){
            result[i]=stack.peek();
            }
            else{
                result[i]=arr.length;
            }
            stack.push(i);
        }
        return result;
    }
    public int[] pse(int []arr){
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() &&arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
            result[i]=stack.peek();
            }
            else{
                result[i]=-1;
            }
            stack.push(i);
        }
        return result;
    }
}