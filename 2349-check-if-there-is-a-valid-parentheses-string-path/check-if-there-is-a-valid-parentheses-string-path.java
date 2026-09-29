class Solution {
    boolean visited[][][];
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if((m+n-1)%2!=0)return false;
        
        visited=new boolean[m][n][m+n];
        return dfs(0,0,0,grid);

    }public boolean dfs(int row,int col,int balance, char [][]grid){
        if(visited[row][col][balance])return false;
        visited[row][col][balance]=true;
        if(grid[row][col]=='('){
            balance++;
        }
        else {balance--;}

        if(balance<0) return false;


        if(row==grid.length-1 && col==grid[0].length-1){
            if(balance==0) return true;
            else {return false;}

        }
        boolean right=false;
        boolean left=false;
        
        if(col+1<grid[0].length) {         right=dfs(row,col+1,balance,grid);
}
        if(row+1<grid.length){         left=dfs(row+1,col,balance,grid);
}

        return right || left;

    }
}