package com.hzins.thrift.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * #author qinghao
 * #date 2019-05-12 10:48
 */
public class DanlianTest {

    public static void main(String[] args) {

        Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, new Node(8, new Node(9, new Node(10, null))))))))));

        printNode(node);


        System.out.println("反转");

        Node head = new Node(-1,null);
        head.next = node;
        Node index = node.next ;

        Node realFirst = head.next;


        Node nextIndex = null  ;

        do {
//            nextIndex  = realFirst.next;
            nextIndex  = index.next;
//
            realFirst.next = index.next;
            index.next = head.next;
            head.next = index;




            index = nextIndex;
//            System.out.println("====" + index.data);
//            System.out.println("====" + realFirst.data);

            printNode(head);


            System.out.println();
       } while (nextIndex != null);

        printNode(node);
    }

    private static void printNode(Node node) {
        System.out.print("链表");
        Node index = node;
        do {

            System.out.print(index.data + " ");
            index = index.next;
        } while (index != null) ;



    }

    @Data
    @AllArgsConstructor
    public static class Node {
        int data;
        Node next;
    }
}
