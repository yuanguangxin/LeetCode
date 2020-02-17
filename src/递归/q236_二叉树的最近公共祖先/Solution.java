package 递归.q236_二叉树的最近公共祖先;

/**
 * LCA二叉树的最近公共祖先（递归）o(n)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right == null) {
            //左子树上能找到，但是右子树上找不到，此时就应当直接返回左子树的查找结果
            return left;
        } else if (left == null) {
            //右子树上能找到，但是左子树上找不到，此时就应当直接返回右子树的查找结果
            return right;
        }
        //左右子树上均能找到，说明此时的p结点和q结点分居root结点两侧，此时就应当直接返回root结点
        return root;
    }
}
