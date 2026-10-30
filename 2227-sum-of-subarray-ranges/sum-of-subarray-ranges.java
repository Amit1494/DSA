class Solution {
    public long subArrayRanges(int[] arr) {
        return sumSubarrayMax(arr)-sumSubarrayMins(arr);
    }
    public long sumSubarrayMins(int[] arr) {
        int pse[]=pse(arr);
        int nse[]=nse(arr);
        long total=0;
        
       
        for(int i=0;i<arr.length;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            long contribution=((long)left*right);
            contribution=(contribution*arr[i]);
            total=(total+contribution);
        }
        return total;
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
    public long sumSubarrayMax(int []arr){
        int pge[]=pge(arr);
        int nge[]=nge(arr);
        long total=0;
        
        
        for(int i=0;i<arr.length;i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            long contribution=((long)left*right);
            contribution=(contribution*arr[i]);
            total=(total+contribution);
        }
        return total;
    }

    public int[] nge(int []arr){
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
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
    public int[] pge(int []arr){
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() &&arr[stack.peek()]<=arr[i]){
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

