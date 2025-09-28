class Solution {
    public List<List<Integer>> permute(int[] nums) {
     List<List<Integer>> list= new ArrayList<>();
     permutation(nums,0,nums.length-1,list);
     return list;
         
}
   public void permutation(int nums[],int left,int right, List<List<Integer>> list)
   {
    if(left==right)
    {
       List<Integer> temp = new ArrayList<>();
       for (int num : nums) {
       temp.add(num);
      }
        list.add(temp);
        return;
    }
    for(int i=left;i<=right;i++)
    {
        swap(nums,left,i);
        permutation(nums,left+1,right,list);
        swap(nums,left,i);//backtrack
    }
   }
    public void swap(int nums[],int left,int right)
    {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
    
   
}