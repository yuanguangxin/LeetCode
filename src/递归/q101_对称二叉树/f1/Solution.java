package 递归.q101_对称二叉树.f1;

import java.util.ArrayList;
import java.util.List;

/**
 * 层序遍历放入list对比 o(n*log(n))
 */
public class Solution {
    public boolean isSymmetric(List<TreeNode> nodes) {
        if (nodes.size() < 2) {
            return true;
        }
        int i = 0;
        int j = nodes.size() - 1;
        while (i < j) {
            if (nodes.get(i) == nodes.get(j)) {
                i++;
                j--;
            } else if (nodes.get(i) == null || nodes.get(j) == null || nodes.get(i).val != nodes.get(j).val) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() != 0) {
            List<TreeNode> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    temp.add(list.get(i).left);
                    temp.add(list.get(i).right);
                }
            }
            if (!isSymmetric(temp)) {
                return false;
            }
            list = temp;
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
