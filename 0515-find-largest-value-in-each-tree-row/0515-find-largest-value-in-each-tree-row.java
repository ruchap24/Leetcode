/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list;

    public List<Integer> largestValues(TreeNode root) {
        
        list=new ArrayList<>();
        dfs(root, 0); 
    
        return list;
    }


    void dfs(TreeNode root, int level){
        if(root==null) return;

        if(level==list.size()){         
            list.add(root.val);
        }
        else if(list.get(level)<root.val){
            list.set(level, root.val);
        }
                
        dfs(root.left, level+1);
        dfs(root.right, level+1);       
    }

}