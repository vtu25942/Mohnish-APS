class Solution {
    void dfs( List<Node> nodes, TreeNode root, int col, int row) {
        if(root==null) return;
        nodes.add(new Node(root.val,col,row));
        dfs(nodes,root.left,col-1,row+1);
        dfs(nodes,root.right,col+1,row+1);
    } 
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> nodes = new ArrayList<>();
        dfs(nodes,root,0,0);
        List<List<Integer>> ans = new ArrayList<>();
        
        nodes.sort((a,b)->{
            if(a.col!=b.col) return Integer.compare(a.col,b.col);
            if(a.row!=b.row) return Integer.compare(a.row,b.row);
            return Integer.compare(a.val,b.val);
        });
        Integer prevCol = Integer.MIN_VALUE;

        for(Node cur: nodes) {
            if(cur.col!=prevCol) {
                prevCol = cur.col;
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size()-1).add(cur.val);
        }
        return ans;
    }
    public static class Node {
        int val, col,row;
        Node(int v, int c, int r) {
            val = v;
            col = c;
            row = r;
        }
    }
}
