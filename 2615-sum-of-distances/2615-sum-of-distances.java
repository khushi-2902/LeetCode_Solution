class Solution {
    public long[] distance(int[] nums) {
         HashMap<Integer,List<Integer>> hm=new HashMap<>();
         
         long ans[]=new long[nums.length];

         for(int i=0;i<nums.length;i++)
         {

             if(hm.containsKey(nums[i]))
             {
                 hm.get(nums[i]).add(i);
             }
             else
             {
                List<Integer> list=new ArrayList<>();
                list.add(i);
                hm.put(nums[i],list);
             }
         }

        for(int key : hm.keySet()) {
    List<Integer> list = hm.get(key);
     long totalSum=sum(list);
     long prefixSum=0;
     int n=list.size();
     if(n==1)
     {
        ans[list.get(0)]=0;
     }
     else
     {
      for(int i=0;i<list.size();i++)
      {
                  //no of times of prefixSumSubtracted with prefixSum+SuffixSum-number of times it will get subtracted
            ans[list.get(i)] = ((long)list.get(i) * i - prefixSum) 
                + (totalSum - prefixSum - list.get(i)) 
                - (long)list.get(i) * (n - i - 1);
            prefixSum+=list.get(i);
      }
     }

           

    }
    return ans;
}
public static long sum(List<Integer> list)
{
  long totalSum=0;
    for(int i=0;i<list.size();i++){
        totalSum+=list.get(i);
    }
    return totalSum;
}

}