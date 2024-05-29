class Solution {
    int[] parent;
    public int makeConnected(int n, int[][] connections) {
        int extra_edges = 0;
        int components = n;
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        for(int[] connection : connections){
            if(find(connection[0]) == find(connection[1])) {
                extra_edges += 1;
            } else {
                union(connection[0], connection[1]);
                components -=1;
            }
        }
        
        
        if(extra_edges >= (components - 1)){
            return components - 1;
        } else {
            return -1;
        }
    }
    
    public int find(int node){
        while(parent[node] != node){
            node = parent[node];
        }
        return node;
    }
    
    public void union(int i, int j){
        int iRoot = find(i);
        int jRoot = find(j);
        if(iRoot != jRoot){
            parent[jRoot] = iRoot;
        }
    }
}