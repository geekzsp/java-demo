package xyz.mosss.spring.examples.springboot.leetcode;

public class Code206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
          ListNode curr=head;
          ListNode prev=null;
          while (curr!=null){
              ListNode temp=curr.next;
              curr.next=prev;
              prev=curr;
              curr=temp;
          }
          return prev;
    }

    //[1,2,3,4,5,null]
    public static void main(String[] args) {
        //[1,2,3,4,5,null]
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = arrayToListNode(arr);
        System.out.println(listNode);
        reverseList(listNode);
    }

    //数组转换成链表
    public static ListNode arrayToListNode(int[] s) {
        ListNode root = new ListNode(s[0]);//生成链表的根节点，并将数组的第一个元素的值赋给链表的根节点
        ListNode other = root;//生成另一个节点，并让other指向root节点，other在此作为一个临时变量，相当于指针
        for (int i = 1; i < s.length; i++) {//由于已给root赋值，所以i从1开始
            ListNode temp = new ListNode(s[i]);//每循环一次生成一个新的节点,并给当前节点赋值
            other.next = temp;//将other的下一个节点指向生成的新的节点
            other = temp;//将other指向最后一个节点(other的下一个节点)  other=other.getNext();
        }
        return root;
    }
}
