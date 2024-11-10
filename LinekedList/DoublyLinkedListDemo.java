package LinekedList;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    
    public DoublyLinkedList() {
        this.head = null;
    }
    //append in last
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            // Traverse to the last node
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    //append in start
    public void prepend(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    //delete first occurence of node
    public void delete(int data) {
        if (head == null) return;

        Node current = head;

        // Find the node with the given data
        while (current != null && current.data != data) {
            current = current.next;
        }

        // If the node is not found
        if (current == null) return;

        // If the node to be deleted is the only node in the list
        if (current == head && current.next == null) {
            head = null;
        }
        // If the node to be deleted is the head node
        else if (current == head) {
            head = current.next;
            head.prev = null;
        }
        // If the node to be deleted is in the middle or the last node
        else if (current.next == null) { // Last node
            current.prev.next = null;
        }
        // If the node is in the middle of the list
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }
    // Method to print the list in forward direction
    public void print() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.print();
        ll.prepend(0);
        ll.print();
        ll.delete(2);
        ll.print();
        ll.delete(0);
        ll.print();
        ll.delete(3);
        ll.print();
        ll.delete(99);
        ll.delete(1);
        ll.print();
        ll.delete(1);
    }
    
}
