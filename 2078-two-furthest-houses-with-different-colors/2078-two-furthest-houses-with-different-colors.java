class Solution {
    public int maxDistance(int[] colors) {
        int i=0;
        int j=colors.length-1;
        int dist=0;
        int max=Integer.MIN_VALUE;
        while(i<j)
        {
            if(colors[i]!=colors[j])
            {
                dist=j-i;
                max=Math.max(max,dist);
                break;
            }
            else
            {
                j--;
            }
        }
        i=0;
        j=colors.length-1;
          while(i<j)
        {
            if(colors[i]!=colors[j])
            {
                dist=j-i;
                max=Math.max(max,dist);
                break;
            }
            else
            {
                i++;
            }
        }
        return max;
    }
}