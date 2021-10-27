package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo1 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree("[3,9,20,5,null,15,7]");
        List<List<Integer>> result = getResult(treeNode);
        result.toString();
        System.out.println(result.toString());
    }

    private static List<List<Integer>> getResult(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> res = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                res.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(res);
        }
        return result;
    }
}