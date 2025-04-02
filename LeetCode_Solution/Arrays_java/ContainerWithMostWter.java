class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int water=0;
        int maxwater=Integer.MIN_VALUE;
        while(left<right)
        {
            int h=Math.min(height[left],height[right]);
            int width=right-left;
             water=h*width;
             maxwater=Math.max(water,maxwater);
             if(height[left]<height[right])
             {
                left++;
             }
             else{
                right--;
             }
    
        }
        return maxwater;
    }
}