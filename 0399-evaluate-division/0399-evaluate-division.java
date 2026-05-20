import java.util.*;

class Solution {

    class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

 
        HashMap<String, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
               graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new Pair(v, val));
            graph.get(v).add(new Pair(u, 1.0 / val));
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {

            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                ans[i] = -1.0;
            } else {

                HashSet<String> visited = new HashSet<>();

                ans[i] = dfs(graph, src, dest, 1.0, visited);
            }
        }

        return ans;
    }

    public double dfs(HashMap<String, List<Pair>> graph,String src,String dest,double product,HashSet<String> visited) {

        if (src.equals(dest)) {
            return product;
        }

        visited.add(src);

        for (Pair neighbor : graph.get(src)) {

            if (!visited.contains(neighbor.node)) {

                double result = dfs( graph,neighbor.node,dest,product * neighbor.value,visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}