class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList(), 0, graph);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, ArrayList<Integer> path, int cur, int[][] graph){
        path.add(cur);
        if(cur == graph.length - 1){
            res.add(new ArrayList(path));
        }else{
            for(int neighbor: graph[cur]){
                dfs(res, path, neighbor, graph);
            }
        }
        
        path.remove(path.size() - 1);
        
    }
}