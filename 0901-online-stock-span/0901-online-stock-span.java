class StockSpanner {



    public Stack<Integer> s;
    HashMap<Integer,Integer> hm=new HashMap<>();
    public StockSpanner() {
         s=new Stack<>();
    
    
    
    
    }
    
    public int next(int price) {
        int ans=0;
        
        if(s.isEmpty() || s.peek()>price)
        {
            hm.put(price,1);
            s.push(price);
            return 1;

        }
        else
        {
            while(!s.isEmpty() && s.peek()<=price)
            {
                ans+=hm.get(s.peek());
                s.pop();
            }
            hm.put(price,ans+1);
            s.push(price);
          
        }
        return ans+1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */