package org.example.test;

public class SinglyLinkedList {

    class Node {
        String value;
        Node next = null;

        Node(String value) {
            this.value = value;
        }
    }

    Node node;

    public boolean isEmpty() {
        if(node == null) {
            return true;
        }
        return false;
    }

    public int length() {
        int count = 0;
        if(node == null) {
            return 0;
        }
        Node temp = node;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void append(String value) {

        // check if list is empty
        if(node == null) {
            node = new Node(value);
            return;
        }
        // if not we will point to the next
        while(node.next != null) {
            node = node.next;
        }
        // after finding the node then point to the new node
        node.next = new Node(value);
    }

    // method to get the length of the linked list

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
    }
}
