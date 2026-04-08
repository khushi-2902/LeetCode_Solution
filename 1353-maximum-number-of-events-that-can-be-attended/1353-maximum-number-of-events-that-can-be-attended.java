class Solution {
    public int maxEvents(int[][] events) {
         Arrays.sort(events,(a,b)->a[0]-b[0]);//sort based on start time
         PriorityQueue<Integer> pq=new PriorityQueue<>();
         

          int i=0;
          int days=0;
          int count=0;
          int n=events.length;
          while(i<n || !pq.isEmpty())
          {
             if(pq.isEmpty())
             {
                days=events[i][0];

             }
             while(i<n && events[i][0]==days)
             {
                 pq.add(events[i][1]);
                 i++;
             }
             while(!pq.isEmpty() && pq.peek()<days)
             {
                pq.poll();

             }
             if(!pq.isEmpty())
             {
                pq.poll();
                count++;
                 days++;
             }
          
          
         }
         return count;
}
}