class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int matrix[][]=new int[8][8];
        int sr=source[0];
        int sc=source[1];
        int tr=target[0];
        int tc=target[1];
        //target is unreachable-------
        // if(Math.abs(sr-sc)!=Math.abs(tr-tc) && sr+sc!=tr+tc )
        // {
        //     return -1;
        // }---this is not the correct unreachable condition -------




        // //correct condition for unreachable
        // if(((tr+tc)%2==0 && (sr+sc)%2!=0)  || ((tr+tc)%2!=0 && (sr+sc)%2==0)) //use the bracets correctly because %have the high precdence than the + operator 
        // {
        //     return -1;
        // }
        //simpler condiition from this if the remainders are same they are having the ame parity and if the remainders are different they are having the different parityy
        if((tr+tc)%2!=(sr+sc)%2)
        {
            return -1;
        }

         if(sr-sc==tr-tc || sr+sc==tr+tc)
         {
            return 1;
         }
         return 2;
        // solve(matrx,source[0],source[1],target[0],target[1]);
    }


























// class Solution {
//     public int minBishopMoves(int[] source, int[] target) {
//         int matrix[][]=new int[8][8];
//         //target is unreachable
//         if(source[0]-source[1]!=target[0]-target[1] && source[0]+source[1]!=target[0]+target[1] )
//         {
//             return -1;
//         }


//         // solve(matrx,source[0],source[1],target[0],target[1]);
//     }
    // public int solve(int matrix[][],int sr,src,int tr,tc)
    // {
    //    //baseCase
    //    //out of the boundaryy
    //    if(sr>=matrix.length && sc>=matrix[0].length && sr<0 && sc<0)
    //    {
    //       return;
    //    }
    //    if(sr-sc==tr-tc || sr+sc==tr+tc)
    //    {
         
    //    }

    //    if(tr>sr)//so i have to search at upper boundary
    //    {
          
    //     //so there could be the two calls
    //     solve(matrix,sr+1,sc+1,tr,tc);
        
    //     solve(matrix,sr+1,sc-1,tr,tc);


    //    }
    //    if(tr<sr)//so i have to search at lower boundary
    //    {
    //      solve(matrix,sr-1,sc+1,tr,tc);
        
    //     solve(matrix,sr-1,sc-1,tr,tc);

    //    }

    // }
}