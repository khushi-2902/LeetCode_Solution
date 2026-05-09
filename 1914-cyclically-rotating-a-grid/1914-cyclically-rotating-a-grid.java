class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
            

           int top = 0;
        int bottom = grid.length - 1;

        int left = 0;
        int right = grid[0].length - 1;

        int layer = 0;
            

        while (top < bottom && left < right) {
              int p=0;
            // TOP ROW
              int size = 2 * ((bottom - top) + (right - left));
int arr[] = new int[size];
            for (int j = left; j <= right; j++) {
              arr[p]=grid[top][j];
              p++;
            }

            // RIGHT COLUMN
            for (int i = top + 1; i <= bottom - 1; i++) {
                arr[p]=grid[i][right];
                p++;
            }

            // BOTTOM ROW
            for (int j = right; j >= left; j--) {
                arr[p]=grid[bottom][j];
                p++;
            }

            // LEFT COLUMN
            for (int i = bottom - 1; i >= top + 1; i--) {
                arr[p]=grid[i][left];
                p++;
            }

           rotate(arr,k);
           fillTheGrid(grid,top,bottom,left,right,arr);
        
            // MOVE TO INNER LAYER
            top++;
            bottom--;

            left++;
            right--;

            layer++;
        }
        
        return grid;

      
    }
    public void rotate(int arr[],int k)
    {
        int n=arr.length;
        k=k%n;
       reverse(0,n-1,arr);
       reverse(0,n-k-1,arr);
       reverse(n-k,n-1,arr);

        
    }
    public void reverse(int i,int j,int arr[])
    {
        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public void fillTheGrid(int grid[][],int top,int bottom,int left,int right,int arr[])
    {
       
        
         
              int p=0;
            // TOP ROW
            for (int j = left; j <= right; j++) {
              grid[top][j]=arr[p];
              p++;
            }

            // RIGHT COLUMN
            for (int i = top + 1; i <= bottom - 1; i++) {
                grid[i][right]=arr[p];
                p++;
            }

            // BOTTOM ROW
            for (int j = right; j >= left; j--) {
                grid[bottom][j]=arr[p];
                p++;
            }

            // LEFT COLUMN
            for (int i = bottom - 1; i >= top + 1; i--) {
                grid[i][left]=arr[p];
                p++;
            }

        
    }
}