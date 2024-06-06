class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        ArrayList<String> res = new ArrayList<>();
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> indegrees = new HashMap<>();
        
        for(int i=0; i<ingredients.size(); i++){
            for(int j=0; j<ingredients.get(i).size(); j++){
                adj.putIfAbsent(ingredients.get(i).get(j), new ArrayList<>());
                adj.get(ingredients.get(i).get(j)).add(recipes[i]);
                indegrees.put(recipes[i], indegrees.getOrDefault(recipes[i], 0) + 1);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        for(String s: supplies){
            q.add(s);
        }
        
        while(!q.isEmpty()){
            String current = q.poll();
            if(!adj.containsKey(current)){
                continue;
            }
            
            for(String recipe: adj.get(current)){
                int value = indegrees.get(recipe);
                indegrees.put(recipe, value - 1);
                if((value - 1) == 0){
                    q.add(recipe);
                    res.add(recipe);
                }
            }
        }
        
        return res;
    }
}