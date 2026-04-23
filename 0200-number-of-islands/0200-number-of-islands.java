class Solution {
    public int numIslands(char[][] grid) {
      int  count=0;
      boolean vis[][]=new boolean[grid.length][grid[0].length];
      for(int i=0;i<grid.length;i++)
      {
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[i][j]=='1' && !vis[i][j])
            {
                solve(vis,grid,i,j);
                count++;
            }
        }
      }
      return count;
}
public void solve(boolean vis[][],char grid[][],int i ,int j)
{
    if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || vis[i][j]==true)
    {
        return;
    }
    vis[i][j]=true;
    solve(vis,grid,i+1,j);
    solve(vis,grid,i,j+1);
    solve(vis,grid,i-1,j);
    solve(vis,grid,i,j-1);
}
}