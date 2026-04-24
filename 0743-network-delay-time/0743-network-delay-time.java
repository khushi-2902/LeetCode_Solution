class Solution {
    static class Pair
    {
        int node;
        int dist;
        Pair(int node,int dist)
        {
            this.node=node;
            this.dist=dist;
        }
    }
    static class Node
    {
        int value;
        int distance;
        Node(int value,int distance)
        {
            this.value=value;
            this.distance=distance;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
         ArrayList<ArrayList<Node>> list=new ArrayList<>();
         for(int i=0;i<=n;i++)
         {
            list.add(new ArrayList<>());
         }
         for(int i=0;i<times.length;i++)
         {
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            list.get(u).add(new Node(v,w));

         }
         PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
         int dist[]=new int[n+1];
         Arrays.fill(dist,Integer.MAX_VALUE);
         dist[k]=0;
         pq.add(new Pair(k,0));
         while(!pq.isEmpty())
         {
            Pair curr=pq.poll();
            int currNode=curr.node;
            int currDist=curr.dist;
            if(currDist>dist[currNode])
            {
                continue;
            }
            for(Node neighb:list.get(currNode))
            {
                int v=neighb.value;
                int w=neighb.distance;
                if(dist[currNode]+w<dist[v])
                {
                    dist[v]=currDist+w;
                    pq.add(new Pair(v,dist[v]));
                }
            }
         }
         int ans=0;
         for(int i=1;i<dist.length;i++)
         {
            if(dist[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
            ans=Math.max(ans,dist[i]);

         }
         return ans;
    }
}