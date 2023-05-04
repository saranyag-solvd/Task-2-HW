package com.solvd.travelagency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList<T> {
    private static final Logger logger = LogManager.getLogger(CustomLinkedList.class);
    Node<T> head;
    private int length = 0;

    public CustomLinkedList() {
        this.head = null;
    }

    // Method to return LinkedList size
    public int size() {
        return this.length;
    }

    // Method to add node at the end of the list
    public void add(T data) {
        this.addLast(data);
    }

    // Method to add node at the start of the list
    public void addFirst(T data) {

        Node<T> newNode = new Node<>(data); // new node

        Node<T> tempNode = this.head;
        this.head = newNode;
        this.head.next = tempNode;

        this.length++; // increment list length
        logger.debug("Node added as Head");
    }

    // Method to add node at the end of the list
    public void addLast(T data) {

        Node<T> newNode = new Node<>(data); // new node

        if (this.head == null) { // add as head node if list is empty
            this.head = newNode;
        } else {

            // iterate till end of list
            Node<T> lastNode = this.head;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }

            lastNode.next = newNode; // add the node at the end of list
        }

        this.length++; // increment list length
        logger.debug("Node added to " + (this.length - 1) + " position");
    }

    // Method to add node at the end of the list
    public void add(int position, T data) {


        if (position > this.length) {
            logger.error("Position " + position + " unavailable to add");
            return;
        }

        if (position == 0) { // add as head node if position is 0
            addFirst(data);
        } else {
            Node<T> newNode = new Node<>(data); // new node
            Node<T> currNode = this.head; // current node
            Node<T> prevNode = new Node<>(null); // prev node

            int cnt = 0;
            while (cnt < position) { // travers the list to the requested position
                prevNode = currNode;
                currNode = currNode.next;
                cnt++;
            }
            //add node to the index.
            prevNode.next = newNode; // update newnode as prev node's next
            newNode.next = currNode; // update current Node as newNode's next
            this.length++; // increment list length
            logger.debug("Node added to " + position + " position");
        }
    }

    // Method to remove node at a position
    public void remove(int position) {

        if (position >= this.length) {
            logger.error("Position " + position + " unavailable to remove");
            return;
        }

        Node<T> currNode = this.head; // current node
        if (position == 0) { // remove head node if position is 0
            this.head = currNode.next;
            this.length--; // decrement list length
            logger.debug("Head Node removed");
        } else {
            Node<T> prevNode = new Node<>(null); // prev node

            int cnt = 0;
            while (cnt < position) { // travers the list to the requested position
                prevNode = currNode;
                currNode = currNode.next;
                cnt++;
            }

            prevNode.next = currNode.next; // update prev node's next to current node's next to unlink current node

            this.length--; // decrement list length
            logger.debug("Node removed from " + position + " position");
        }
    }

    // Method to get data from a position
    public T get(int position) {
        T data = null;

        if (position >= this.length) {
            logger.error("Position " + position + " unavailable to get");
        } else if (position == 0) { // add as head node if position is 0
            data = this.head.data;
        } else {
            Node<T> currNode = this.head; // current node

            int cnt = 0;
            while (cnt < position) { // travers the list to the requested position
                currNode = currNode.next;
                cnt++;
            }
            data = currNode.data;

        }
        return data;
    }

    public void show() {
        Node currNode = this.head;

        String printStr = "";
        while (currNode != null) {
            printStr = printStr + currNode.data + ", ";

            currNode = currNode.next;
        }
        logger.debug("LinkedList: " + printStr);
    }

    @Override
    public String toString() {
        return "CustomLinkedList{" +
                "head=" + head.data +
                "next=" + head.next.data +
                ", length=" + length +
                '}';
    }

    class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }


}
