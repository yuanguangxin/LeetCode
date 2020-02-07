package q98.f2;

import java.util.Stack;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(6);
        n2.left = n3;
        n2.right = n4;
        System.out.println(new Solution().isValidBST(root));
    }
}
