package String_java;

import java.util.HashMap;

public class LongestSubstclass Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int length=0;
        int maxlength=0;
        while(j<s.length())
        {
            char ch=s.charAt(j);
            if(!map.containsKey(ch))
            {
                map.put(ch,1);
            }
            else
            {
                map.remove(ch);
                while(s.charAt(i)!=ch)
                {
                   map.remove(s.charAt(i));
                   i++;
                  
                }
                i++;
                map.put(ch,1);
                

            }
            length=map.size();
            maxlength=Math.max(length,maxlength);
            j++;
        }
        return maxlength;
    }
} 
    

