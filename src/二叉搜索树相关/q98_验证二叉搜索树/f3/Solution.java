package 二叉搜索树相关.q98_验证二叉搜索树.f3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历迭代法判断上下界 o(n)
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Queue<Integer> min = new LinkedList<>();
        Queue<Integer> max = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            Integer maxt = max.poll();
            Integer mint = min.poll();

            if (mint != null && temp.val <= mint) {
                return false;
            }
            if (maxt != null && temp.val >= maxt) {
                return false;
            }

            if (temp.left != null) {
                min.add(mint);
                max.add(temp.val);
                queue.add(temp.left);
            }

            if (temp.right != null) {
                max.add(maxt);
                min.add(temp.val);
                queue.add(temp.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(15);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(20);
        n2.left = n3;
        n2.right = n4;
        System.out.println(new Solution().isValidBST(root));
    }
}