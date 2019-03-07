package leetcode;
/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。*/
class test1 {
    public static void main(String[] args){
        Solution ss=new Solution();
        ListNode l1=new ListNode(2);
        ListNode l12=new ListNode(4);
        ListNode l13=new ListNode(3);
        l1.next=l12;
        l12.next=l13;

        ListNode l2=new ListNode(5);
        ListNode l22=new ListNode(6);
        ListNode l23=new ListNode(4);
        l2.next=l22;
        l22.next=l23;

        ListNode l3=ss.addTwoNumbers(l1,l2);
        System.out.print(l3.val);
        System.out.print(" ");
        while(l3.next!=null){
            System.out.print(l3.next.val);
            System.out.print(" ");
            l3=l3.next;
        }
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

