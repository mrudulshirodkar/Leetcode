class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for(int[] time: times){
            adj.putIfAbsent(time[0], new HashMap<>());
            adj.get(time[0]).put(time[1], time[2]);
        }
        
        boolean[] visited = new boolean[n+1];
        int res = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        queue.add(new int[]{k, 0});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentNode = current[0];
            int time = current[1];
            if(visited[currentNode]){
                continue;
            }
            visited[currentNode] = true;
            res = time;
            n--;
            
            if(adj.containsKey(currentNode)){
                for(int neighbor: adj.get(currentNode).keySet()){
                    queue.add(new int[]{neighbor, time+adj.get(currentNode).get(neighbor)});
                }
            }
        }
        
        return n==0?res: -1;
    }
}