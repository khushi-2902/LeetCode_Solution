class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int k=groupSize;
            TreeMap<Integer,Integer> tm=new TreeMap<>();

        for(int i=0;i<hand.length;i++)
        {
            tm.put(hand[i],tm.getOrDefault(hand[i],0)+1);
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