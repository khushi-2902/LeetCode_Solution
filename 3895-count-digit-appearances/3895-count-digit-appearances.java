class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            String s = Integer.toString(nums[i]);
            for(int j=0;j<s.length();j++)
            {
                char ch=s.charAt(j);
                int currentdigit = ch - '0';
                if(currentdigit==digit)
                {
                    count++;
                }
            }
        }
        return count;
        
    }
}