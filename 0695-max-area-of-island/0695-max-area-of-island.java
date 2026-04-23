class Solution {

    public int maxAreaOfIsland(int[][] grid) {
       int max=0;
       boolean vis[][]=new boolean[grid.length][grid[0].length];
       for(int i=0;i<grid.length;i++)
       {
        for(int j=0;j<grid[0].length;j++)
        {
            if(!vis[i][j] && grid[i][j]==1)
            {
                int ans=solve(i,j,grid,vis);
                max=Math.max(ans,max);
            }
        }
       }
       return max;
    }
    public int solve(int i,int j,int grid[][],boolean vis[][])
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j]==0)
        {
            return 0;
        }
         vis[i][j]=true;
        return 1+solve(i+1,j,grid,vis)+solve(i,j+1,grid,vis)+solve(i-1,j,grid,vis)+solve(i,j-1,grid,vis);
        
   
        
    }
}