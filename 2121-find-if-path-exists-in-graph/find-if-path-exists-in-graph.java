class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:edges){
            int u=i[0];
            int v=i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(source,adj,visited);
        return visited[destination];
    }
    private void dfs(int source,ArrayList<ArrayList<Integer>>adj,boolean visited[]){
        visited[source]=true;
        for(int i:adj.get(source)){
            if(!visited[i]){
                dfs(i,adj,visited);
            }
        }
    }
}