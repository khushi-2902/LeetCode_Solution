class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length-1;
        int m=grid[0].length-1;
         if(grid[0][0]==1 || grid[n][m]==1)
         {
            return -1;
         }
         
         Queue<int[]> q=new LinkedList<>();
         boolean vis[][]=new boolean[n+1][m+1];
         int dirX[]={-1,1,0,0,-1,-1,1,1};
        int dirY[]={0,0,-1,1,-1,1,-1,1};

         q.add(new int[]{0,0,1});
         vis[0][0]=true;
         while(!q.isEmpty())
         {
            int curr[]=q.poll();
            
           if(curr[0]==n && curr[1]==m)
           {
            return curr[2];
           }
           for(int i=0;i<8;i++)
           {
             int newX=curr[0]+dirX[i];
             int newY=curr[1]+dirY[i];
             if(newX>=0 && newY>=0 && newX<grid.length && newY<grid[0].length && !vis[newX][newY])
             {
               if(grid[newX][newY]==0)
               {
                vis[newX][newY]=true;
                q.add(new int[]{newX,newY,curr[2]+1});
               }
             }
           }
            
         }
         return -1;
          
    }
}