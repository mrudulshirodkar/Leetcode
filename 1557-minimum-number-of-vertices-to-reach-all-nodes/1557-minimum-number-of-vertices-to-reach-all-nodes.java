class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<Integer> res = new ArrayList<>();
        
        ArrayList<Integer> [] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        
        int[] inDegree = new int [n];
        for(List<Integer> edge: edges){
            // adj[edge.get(0)].add(edge.get(1));
            inDegree[edge.get(1)]++;
        }
        
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                res.add(i);
            }
        }
        
        return res;
    }
    
}