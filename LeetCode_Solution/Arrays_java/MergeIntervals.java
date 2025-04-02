class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        
         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i=0;i<intervals.length;i++)
        {
                int temp[]=new int[2];
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