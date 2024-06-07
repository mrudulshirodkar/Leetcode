class Solution {
    public class Node{
        String key;
        double value;
        public Node(String key, double value){
            this.key = key;
            this.value = value;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, List<Node>> graph = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            String source = equations.get(i).get(0);
            String destination = equations.get(i).get(1);
            graph.putIfAbsent(source, new ArrayList<>());
            graph.putIfAbsent(destination, new ArrayList<>());
            graph.get(source).add(new Node(destination, values[i]));
            graph.get(destination).add(new Node(source, 1/values[i]));
        }
        
        for(int i=0; i<queries.size(); i++){
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
        }
        
        return result;
    }
    
    public double dfs(String numerator, String denominator, Map<String, List<Node>> graph, 
                     Set<String> visited){
        if(!(graph.containsKey(numerator) && graph.containsKey(denominator))){
            return -1.0;
        }
        if(numerator.equals(denominator)){
            return 1.0;
        }
        visited.add(numerator);
        for(Node node: graph.get(numerator)){
            if(!visited.contains(node.key)){
                double ans = dfs(node.key, denominator, graph, visited);
                if(ans != -1.0){
                    return (ans * node.value);
                }
            }
        }
        return -1.0;
    }
}