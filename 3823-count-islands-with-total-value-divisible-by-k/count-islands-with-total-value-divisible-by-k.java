class Solution {
    public int countIslands(int[][] grid, int k) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean array[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && !array[i][j]){
                        long sum=helper(grid,i,j,array);
                        if(sum%k==0)count++;
                }
            }
        }
        return count;
        
    }
    public long helper(int grid[][],int i,int j,boolean [][]array){
        int n=array.length;
        int m=array[0].length;

        if(i<0||i>=n||j<0||j>=m||grid[i][j]==0||array[i][j])return 0;
        
        array[i][j]=true;
        long count=grid[i][j];
        
        count+=helper(grid,i+1,j,array);
        count+=helper(grid,i-1,j,array);
        count+=helper(grid,i,j+1,array);
        count+=helper(grid,i,j-1,array);
        return count;
    }
}