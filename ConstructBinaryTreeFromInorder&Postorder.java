//Time Complexity: O(N)
//Space COmplexity: O(N)
class Solution {
    int postIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postIndex]);

        --postIndex;

        int index = map.get(root.val);

        root.right = helper(inorder, postorder, index + 1, inEnd);
        root.left = helper(inorder, postorder, inStart, index - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        postIndex = postorder.length - 1;

        return helper(inorder, postorder, 0, inorder.length - 1);
    }
}