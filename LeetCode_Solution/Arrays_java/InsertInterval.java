class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList=new ArrayList<>(Arrays.asList(intervals));
        intervalsList.add(newInterval);
        intervals=intervalsList.toArray(new int[intervalsList.size()][]);
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> merged=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
          if(merged.isEmpty() || merged.get(merged.size()-1)[1]<intervals[i][0])
                {
                    merged.add(intervals[i]);
                }
                else
                {
                   
                    merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],intervals[i][1]);
                }
               
                
        }
         return merged.toArray(new int[merged.size()][]);
    }
}