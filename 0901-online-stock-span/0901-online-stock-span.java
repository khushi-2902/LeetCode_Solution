class StockSpanner {

    class Node
    {
        int pr;
        int value;
        Node(int pr,int value)
        {
            this.pr=pr;
            this.value=value;
        }
    }

    public Stack<Node> s;
   
    public StockSpanner() {
         s=new Stack<>();
    
    
    
    
    }
    
    public int next(int price) {
        int ans=0;
        
        if(s.isEmpty() || s.peek().pr>price)
        {
            
            s.push(new Node(price,1));
            return 1;

        }
        else
        {
            while(!s.isEmpty() && s.peek().pr<=price)
            {
                ans+=s.peek().value;
                s.pop();
            }
            
            s.push(new Node(price,ans+1));
          
        }
        return ans+1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */