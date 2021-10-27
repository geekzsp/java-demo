package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList();
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> curr=new ArrayList();
            for(int i=0;i<size;i++){
                TreeNode treeNode=queue.poll();
                curr.add(treeNode.val);
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            res.add(curr);
        }
        return res;
    }


    public List<Integer> bianli(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.right != null) {
                bianli(root.right, res);
            }
            res.add(root.val);
            if (root.left != null) {
                bianli(root.left, res);
            }
        }
        return res;
    }
}