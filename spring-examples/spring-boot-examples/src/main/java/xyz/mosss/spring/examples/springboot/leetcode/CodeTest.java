package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.Stack;

public class CodeTest {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode listNode = arrToListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(listNode);
    }

    public static ListNode arrToListNode(int[] data){
        ListNode root=new ListNode(data[0]);
        ListNode p=root;
        for(int i=1;i<data.length;i++){
            ListNode temp=new ListNode(i);
            p.next=temp;
            p=temp;
        }
        return root;
    }
    //private static int[] nodeToarr(ListNode listNode) {
    //    while (listNode != null) {
    //
    //    }
    //}

    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        // Now the head is the second node
        return secondNode;
    }

}