class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            int key=(arr[i]%k+k)%k;
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
        for(int key:hm.keySet())
        {
            int value=hm.get(key);
            if(key==0)
            {
                if(value%2!=0)
                {
                  return false;
                }
            }
            else
            {
                int other=k-key;
                int currValue=hm.getOrDefault(other,0);
               if(value!=currValue)
               {
                   return false;
               }
            }
        }
        return true;
    }
}