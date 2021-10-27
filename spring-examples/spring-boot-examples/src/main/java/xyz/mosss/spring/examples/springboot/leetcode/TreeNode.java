package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }


    public static ArrayList<ArrayList<Integer>> getResult(TreeNode root) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (root == null) {
            return arrayLists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> currentRes = new ArrayList<>();
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode treeNode = queue.poll();
                currentRes.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            arrayLists.add(currentRes);
        }
        return arrayLists;
    }

    public String toString() {
        return Integer.toString(val);
    }

    //    int []arr = {3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7};
    private static int[] StrToIntArray(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        int[] arr = new int[strs.length];

        for (int i = 0; i < arr.length; i++) {
            if (strs[i].equals("null")) {
                arr[i] = Integer.MAX_VALUE;
            } else {
                arr[i] = Integer.parseInt(strs[i]);
            }
        }

        return arr;
    }

    //    String str = "[3,9,20,null,null,15,7]";
    public static TreeNode mkTree(String str) {

        int[] arr = StrToIntArray(str);
        TreeNode[] nodes = new TreeNode[arr.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            if (arr[i - 1] != Integer.MAX_VALUE) {
                nodes[i] = new TreeNode(arr[i - 1]);
            } else {
                nodes[i] = null;
            }
        }

        TreeNode node = null;
        for (int i = 1; i < nodes.length / 2; i++) {
            node = nodes[i];
            if (node == null) continue;
            node.left = nodes[2 * i];
            node.right = nodes[2 * i + 1];
        }
        return nodes[1];
    }

    public static void main(String[] args) {
        TreeNode treeNode = mkTree("[3,9,20,null,null,15,7]");
        System.out.println(treeNode);
        ArrayList<ArrayList<Integer>> result = getResult(treeNode);
        System.out.println(result);
    }
}