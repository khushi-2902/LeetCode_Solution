import java.util.*;
class uniqueFrequency {
    public int minDeletions(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            int val=entry.getValue();
            while(!set.isEmpty() && set.contains(val) && val!=0)
            {
               val=val-1;
               ans++;
            }
            set.add(val);
            
        }
        return ans;
    }
}