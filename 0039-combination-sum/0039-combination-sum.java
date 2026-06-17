class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> currList=new ArrayList<>();
        int n=candidates.length-1;
        solve(candidates,target,n,list,currList);
        return list;
    }
    public void solve(int arr[],int target,int n, List<List<Integer>> list,List<Integer> currList)
    {
          if(target==0)
          {
            list.add(new ArrayList<>(currList));
            return;

          }
          if(target<0 || n<0)
          {
            return;
          }



        //condition1
        currList.add(arr[n]);
       solve(arr,target-arr[n],n,list,currList);
        currList.remove(currList.size()-1);
        //condition-2 exclude
        solve(arr,target,n-1,list,currList);
    }
}