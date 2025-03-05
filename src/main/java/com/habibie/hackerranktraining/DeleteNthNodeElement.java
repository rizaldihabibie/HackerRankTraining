package com.habibie.hackerranktraining;

class Node {
    int data;
    Node next;
    Node(int x) {
        this.data = x;
        this.next = null;
    }
}

public class DeleteNthNodeElement {

    public static Node delete(Node head, int n) {
        // initiate node size
        int k = 0;

        // initiate current
        Node current = head;

        // find out the node length
        while(current != null) {
            current = current.next;
            k++;
        }

        // handle edge case : removed the head
        if (k-n == 0) return head.next;

        // set the current back to the head
        current = head;

        for (int i = 0; i< k-n; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        return current;
    }
}
