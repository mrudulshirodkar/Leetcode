class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] distance = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
        }
        
        for(int[] edge: edges){
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }
        
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(distance[i][k]!=Integer.MAX_VALUE && distance[k][j]!=Integer.MAX_VALUE &&
                       distance[i][k] + distance[k][j] < distance[i][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        int city = -1;
        int cityCount = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(distance[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= cityCount){
                cityCount = count;
                city = i;
            }
            
        }
        
        return city;
    }
}