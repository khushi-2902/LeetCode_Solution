public class minimum_rotated_array {
    public static int minimum(int arr[]){
        int orignals=0;
        int orignalend=arr.length-1;
        int start=0;
        int end=arr.length-1;
        if(arr[orignals]<arr[orignalend])
        {
            return arr[0];
        }
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1])
            {
                return arr[mid];
            }
            else if(arr[mid]<arr[orignals] && arr[mid]<arr[orignalend])
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
            
        }
        return 0;
    }
    public static void main (String args[])
    {
      int arr[]={3,4,5,0,1,2};
      System.out.println(minimum(arr));
    }
    
}
