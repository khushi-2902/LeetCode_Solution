class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int endrow=matrix.length-1;
        int col=0;
        int endcol=matrix[0].length-1;
        if(endrow==0 && endcol==0)
        {
            if(target==matrix[0][0])
            {
                return true;
            }
            else
            {
                return false;
            } 
        }
        while(row<=endrow  && endcol>=col )
        {
            if(matrix[row][endcol]==target)
            {
                return true;
            }
            else if(target>matrix[row][endcol])
            {
                row++;
            }
            else
            {
                endcol--;
            }
        }
        return false;
        
    }
}