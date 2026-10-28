class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        TreeMap<Integer,Integer> tm=new TreeMap<>();

        for(int i=0;i<nums.length;i++)
        {
            tm.put(nums[i],tm.getOrDefault(nums[i],0)+1);
        }

       while(!tm.isEmpty())
       {
            int card=tm.firstKey();

            for(int i=card;i<card+k;i++)
            {
                if(!tm.containsKey(i))
                {
                    return false;
                }

                tm.put(i,tm.getOrDefault(i,0)-1);
                if(tm.get(i)==0)
                {
                    tm.remove(i);
                }

            }
       }
       return true;
    }
}