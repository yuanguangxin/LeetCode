package 递归.q101_对称二叉树.f2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 利用队列的层序遍历（广度优先搜索BFS）o(n)
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        root.left = t1;
        root.right = t2;
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t3;
        t1.right = t4;
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(3);
        t2.left = t5;
        t2.right = t6;

        System.out.println(new Solution().isSymmetric(root));
    }
}
