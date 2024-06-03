class Solution {
    long fuel = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        ArrayList<Integer> [] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] road: roads){
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }
        
        dfs(adj, 0, -1, seats);
        return fuel;
    }
    
    public int dfs(ArrayList<Integer> [] adj, int current, int prev, int seats){
        int people = 1;
        for(int neighbor: adj[current]){
            if(neighbor == prev){
                continue;
            }
            people += dfs(adj, neighbor, current, seats);
        }
        
        if(current != 0){
            fuel += (long)Math.ceil((double)people/seats);
        }
        
        return people;
    }
}