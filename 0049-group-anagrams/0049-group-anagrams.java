class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

      HashMap<String,List<String>> hm=new HashMap<>();

      List<List<String>> list=new ArrayList<>();

      for(int i=0;i<strs.length;i++)
      {
        String str=strs[i];
          char arr[]=str.toCharArray();
          Arrays.sort(arr);
          String s=new String();
          for(char ch :arr)
          {
             s+=ch;
          }
          if(hm.isEmpty() || !hm.containsKey(s))
          {
             List<String> curr=new  ArrayList<>();
             curr.add(str);
             hm.put(s,curr);
          }

          else
          {
               List<String> value=hm.get(s);
               value.add(str);
          }

      }

      for(Map.Entry<String,List<String>> entry:hm.entrySet())
      {
           
           list.add(entry.getValue());

      }
      return list;
    }
}