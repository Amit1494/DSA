class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int arr[][]=new int[n][n];
        int i=1;
        arr[0][0]=triangle.get(0).get(0);
        for(;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    arr[i][j]=triangle.get(i).get(j)+arr[i-1][j];
                }
                else if(j==i){
                    arr[i][j]=triangle.get(i).get(j)+arr[i-1][j-1];}
                else{
                    arr[i][j]=triangle.get(i).get(j)+Math.min(arr[i-1][j-1],arr[i-1][j]);
                }
            }
            
        }
        int res=Integer.MAX_VALUE;
        for(int j=0;j<triangle.get(n-1).size();j++){
            res=Math.min(res,arr[i-1][j]);
        }
        return res;
        

    }
}