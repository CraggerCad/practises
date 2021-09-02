package com.progressive.htmlescape.leet;

import java.util.LinkedList;
import java.util.List;

public class Add2Numbers {


    public static void main(String[] args) {

        ListNode currentNode;

        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(4,l3);
        ListNode l1 = new ListNode(2,l2);

        currentNode = l3;

        int num1 = 0;
        int num2 = 0;

        System.out.println("L1");
        do {
            System.out.println("current value = "+currentNode.val);
            num1 = num1 + 10*currentNode.val;
            currentNode = currentNode.next;
        }while (currentNode.next!=null);

        System.out.println("num1="+num1);

        ListNode m1 = new ListNode(4);
        ListNode m2 = new ListNode(6,m1);
        ListNode m3 = new ListNode(5,m2);
        currentNode = m3;

        System.out.println("L2");
        do {
            System.out.println("current value = "+currentNode.val);
            num2 = num2 + 10*currentNode.val;
            currentNode = currentNode.next;
        }while (currentNode.next != null);
        System.out.println("Num2="+num2);
    }
}
