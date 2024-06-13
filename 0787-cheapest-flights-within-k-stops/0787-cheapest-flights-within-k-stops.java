class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for(int[] flight: flights){
            adj.putIfAbsent(flight[0], new HashMap<>());
            adj.get(flight[0]).put(flight[1], flight[2]);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{src, 0});
        
        int[] distanceArray = new int[n];
        Arrays.fill(distanceArray, Integer.MAX_VALUE);
        distanceArray[src] = 0;
        int stops = 0;
        
        while(stops<=k && !queue.isEmpty()){
            int qsize = queue.size();
            while(qsize-- > 0){
                int[] current = queue.poll();
                int vertex = current[0];
                int distance = current[1];
                
                if(adj.containsKey(vertex)){
                    for(int neighbor: adj.get(vertex).keySet()){
                        if((distance + adj.get(vertex).get(neighbor)) > distanceArray[neighbor]){
                            continue;
                        }
                        distanceArray[neighbor] = distance + adj.get(vertex).get(neighbor);
                        queue.add(new int[]{neighbor, distanceArray[neighbor]});
                    }
                }
            }
            stops++;
            
            
        }
        
        if(distanceArray[dst] == Integer.MAX_VALUE) {return -1;}
        else return distanceArray[dst];
        
    }
}