class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int count=0;
        count+=requests[0];
        for(int i=1;i<requests.length;i++)
        {
            count+=Math.abs(requests[i]-requests[i-1]);
              

        }
        return count;
    }
}