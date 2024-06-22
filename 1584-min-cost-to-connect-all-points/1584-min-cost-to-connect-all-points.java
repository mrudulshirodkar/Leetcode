class Solution {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });
        
        queue.offer(new int[]{0, 0, 0});
        
        HashSet<Integer> visited = new HashSet<>();
        int cost = 0;
        
        while(!queue.isEmpty() && visited.size() < length){
            int[] current = queue.poll();
            int end = current[1];
            int dist = current[2];
            
            if(visited.contains(end)){continue;}
            
            visited.add(end);
            cost += dist;
            
            for(int i=0; i<length; i++){
                if(!visited.contains(i)){
                    queue.offer(new int[]{end, i, 
                                          (Math.abs(points[end][0] - points[i][0]) + 
                                           (Math.abs(points[end][1] - points[i][1])))});
                }
            }
        }
        
        return cost;
    }
}