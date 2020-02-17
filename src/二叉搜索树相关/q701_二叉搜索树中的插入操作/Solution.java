package 二叉搜索树相关.q701_二叉搜索树中的插入操作;

/**
 * 递归（大于插入右子树，小于插入左子树） o(n)
 */
public class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode temp = root;
        if (root == null) {
            return node;
        }
        if (val >= root.val) {
            if (root.right == null) {
                root.right = node;
            } else {
                insertIntoBST(root.right, val);
            }
        } else {
            if (root.left == null) {
                root.left = node;
            } else {
                insertIntoBST(root.left, val);
            }
        }
        return temp;
    }
}
