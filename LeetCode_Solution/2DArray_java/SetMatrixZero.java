class Solution {
    public void setZeroes(int[][] matrix) {
        int endrow=matrix.length;
        int endcol=matrix[0].length;
        boolean row[]=new boolean[endrow];
        boolean col[]=new boolean[endcol];
        for(int i=0;i<endrow;i++)
        {
            for(int j=0;j<endcol;j++)
            {
                if(matrix[i][j]==0)
                {
                   row[i]=true;
                   col[j]=true;
                }
            }
            
        }
        for(int i=0;i<endrow;i++)
        {
            for(int j=0;j<endcol;j++)
            {
                if(row[i] || col[j])
                {
                    matrix[i][j]=0;
                }
            }
        }
    
        
    }
   


}