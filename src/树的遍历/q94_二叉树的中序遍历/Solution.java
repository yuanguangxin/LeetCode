package 树的遍历.q94_二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归 o(n)
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            rs.add(root.val);
            root = root.right;
        }
        return rs;
    }
}
