package 二叉搜索树相关.q98_验证二叉搜索树.f2;

/**
 * 寻找上下界递归 o(n)
 */
public class Solution {
    public boolean valid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        int val = root.val;

        if (min != null && val <= min) {
            return false;
        }
        if (max != null && val >= max) {
            return false;
        }

        if (!valid(root.left, min, val)) {
            return false;
        }
        if (!valid(root.right, val, max)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
}
