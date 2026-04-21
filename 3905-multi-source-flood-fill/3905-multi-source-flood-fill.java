class Solution {
    static class Pair
    {
        int row;
        int col;
        int val;
        Pair(int row,int col,int val)
        {
            this.row=row;
            this.col=col;
            this.val=val;

        }
    }

    public int[][] colorGrid(int n, int m, int[][] sources) {
        int mat[][]=new int[n][m];
      
        for(int i=0;i<sources.length;i++)
        {
            mat[sources[i][0]][sources[i][1]]=sources[i][2];
        }

           Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]!=0)
                {
                    q.add(new Pair(i,j,mat[i][j]));
                  
                
                }
                
            }
        }

        solve(n,m,mat,q);
        return mat;
    }
    public static void solve(int n,int m,int sources[][],Queue<Pair> q)
    {
  
       int dirX[]={-1,1,0,0};
       int dirY[]={0,0,-1,1};
     
       while(!q.isEmpty())
       {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int size=q.size();
        for(int i=0;i<size;i++)
        {
         
           Pair curr=q.poll();
           
           for(int j=0;j<4;j++)
            {
                
                int currX=curr.row+dirX[j];
                int currY=curr.col+dirY[j];
                if(currX>=0 && currX<sources.length && currY>=0 && currY<sources[0].length)
            {
                if(sources[currX][currY]==0 )
                {
                    int key=currX*m+currY;
                    hm.put(key,Math.max(hm.getOrDefault(key,0),curr.val));
                }
            }
               
           }
        }
        for(int key:hm.keySet())
        {
            int val=hm.get(key);
            int x=key/m;
            int y=key%m;
            sources[x][y]=val;
            q.add(new Pair(x,y,val));
        }
       }
   }
}