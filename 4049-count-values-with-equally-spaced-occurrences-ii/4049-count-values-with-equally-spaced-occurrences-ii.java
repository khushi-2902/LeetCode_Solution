class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            int key=nums[i];
               if(!map.containsKey(key))
               {
                if(!set.isEmpty() && set.contains(key))
                {
                    continue;
                }
                //i m storing the key->[index,freq,distance]
                  map.put(key,Arrays.asList(i,1,0));
               }
               else
               {
                   List<Integer> list = map.get(key);
                   int index=list.get(0);
                   int freq=list.get(1);
                   int distance=list.get(2);
                   if(freq>=2 && i-index==distance)
                   {
                    
                       list.set(0,i);
                     
                       list.set(1,freq+1);
                   }
                   else if(freq==1)
                   {
                       list.set(0,i);
                        list.set(1,freq+1);
                       list.set(2,i-index);

                   }
                   else
                   {
                    map.remove(key);
                    set.add(key);
                   }
               }
        }
        int count=0;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

           int key = entry.getKey();
           List<Integer> list = entry.getValue();
           int  freq=list.get(1);
           if(freq>=3)
            {
               count++;
             }
         }
         return count;
    }
}