class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int ans=-1;
        int minDistance=Integer.MAX_VALUE;
        for(int i=0;i<drones.length;i++)
            {
                 int x1=drones[i][0];
                int x2=drones[i][1];
                int range=drones[i][2];
                 int distance=Math.abs(x1-target[0])+Math.abs(x2-target[1]);
                if(distance<=range && distance<minDistance)
                {
                    minDistance=distance;
                    ans=i;
                }
                
            
            }
        if(ans==-1)
        {
            return -1;
        }
        return ans;
    }
}