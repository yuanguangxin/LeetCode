package 树的遍历.q110_平衡二叉树.f1;

/**
 * 从顶至底遍历 o(n^2)
 */
public class Solution {

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lh = getHeight(root.left);
            int rh = getHeight(root.right);
            return Math.max(lh, rh) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
//        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        System.out.println(new Solution().isBalanced(root));
    }
}
