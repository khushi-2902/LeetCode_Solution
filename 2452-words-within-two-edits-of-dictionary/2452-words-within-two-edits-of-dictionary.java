class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++)
        {
            for(int j=0;j<dictionary.length;j++)
            {
                if(differenceEnough(queries[i],dictionary[j]))
                {
                    ans.add(queries[i]);
                    break;
                }
            }
        }
        return ans;
    }
    public boolean differenceEnough(String query,String dictionary)
    {
        int i=0;
        int count=0;
        while(i<query.length())
        {
            char q=query.charAt(i);
            char dict=dictionary.charAt(i);
            if(q!=dict && count==2)
            {
                return false;
            }
            if(q!=dict)
            {
                count++;
            }
            i++;
        }
        return  true;
    }
}