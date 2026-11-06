class Solution {
    public int largestRectangleArea(int[] heights) {
        
            int []nse=nextSmaller(heights);
            int []pse=previousSmaller(heights);
            int max=0;
            for(int i=0;i<heights.length;i++){
                int width=nse[i]-pse[i]-1;
                int area=heights[i] * width;
                max=Math.max(max,area);
            }
return max;
        
    }
     public int[] previousSmaller(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() &&
                   arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }
    public int[] nextSmaller(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = arr.length;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }
}