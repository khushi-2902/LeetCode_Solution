class MedianFinder {
   private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
   
    public MedianFinder() {
        left=new PriorityQueue(Collections.reverseOrder());//max-heap
        right=new PriorityQueue();//min-heap

    }
    
    public void addNum(int num) {
        if(left.isEmpty() || num<=left.peek())
        {
            left.add(num);
        }
        else
        {
            right.add(num);
        }
        //balancing heaps
       if(left.size()>right.size()+1)
       {
        right.add(left.poll());
       }
       else if(right.size()>left.size())
       {
          left.add(right.poll());

       }
    }
    
    public double findMedian() {
        
        if(left.size()==right.size())
        {
           return (left.peek()+right.peek())/2.0;
        }
        else
        {
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */