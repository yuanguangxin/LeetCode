package 树的遍历.q103_二叉树的锯齿形层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 和层序遍历相同，额外加一个标记控制插入队列的位置
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode tn = queue.poll();
                if (flag) {
                    list.add(tn.val);
                } else {
                    list.add(0, tn.val);
                }
                if (tn.left != null) {
                    queue.add(tn.left);
                }
                if (tn.right != null) {
                    queue.add(tn.right);
                }
                size--;
            }
            flag = !flag;
            ans.add(list);
        }
        return ans;
    }
}
