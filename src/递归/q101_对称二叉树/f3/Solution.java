package 递归.q101_对称二叉树.f3;

/**
 * 递归 o(n)（如果一个树的左子树与右子树镜像对称，那么这个树是对称的。根结点相同并且每个树的左子树和另一个树的右子树镜像对称的树是镜像对称的）
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
