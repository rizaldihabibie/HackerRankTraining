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
    
    public static void main(String[] args) {
        int[] values = new int[]{1,2,3,4,5,6,7,8,9,10};
                
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        
        
        Node result = delete(head, 3);
        while(result.next != null) {
            System.out.println(result.data);
            result = result.next;
        }
        System.out.println(result.data);
        
    }

    public static Node delete(Node head, int n) {
        int nodeLength = 1;
        
        Node current = head;
        
        while(current.next != null) {
            current = current.next;
            nodeLength++;
        }
        
        
        if (nodeLength - n == 0) return head.next;
        
        current = head;
        
        for(int i = 1; i < nodeLength - n; i++) {
            current = current.next;
        }
        
        current.next = current.next.next;
        
        return head;
    }
}
