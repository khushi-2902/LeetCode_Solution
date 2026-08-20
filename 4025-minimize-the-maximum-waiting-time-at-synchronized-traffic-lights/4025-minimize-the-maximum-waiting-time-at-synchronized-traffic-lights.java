class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
       
       PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a, b) -> Integer.compare(a[0], b[0])
);
        int maxDiff=0;
        for(int i=0;i<arrivalTime.length;i++)
        {
        int r=arrivalTime[i]%period;

        pq.add(new int[]{r,period-r});
       
       
        }

        //i justhave to assign these differneces to the lightss and the waiting time will only be calculated 
        //when r[i]>car[i] that is assigned to it;
       
     
     int k=0;
    while(k<lights.length && !pq.isEmpty())
    {
        int poll[]=pq.poll();
        int r=poll[0];
        int diff=poll[1];
        while(k<lights.length && r>=lights[k])
        {
            k++;
        }
        if(k>=lights.length)
        {
             maxDiff=Math.max(maxDiff,diff);
        }
        
        
    }
    while(!pq.isEmpty())
    {
        int poll[]=pq.poll();
        int diff=poll[1];
        maxDiff=Math.max(maxDiff,diff);
    }


return maxDiff;






    }
}