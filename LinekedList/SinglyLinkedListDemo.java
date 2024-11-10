package LinekedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }
    //append at last
    public void append(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    //append at start
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    //delete first occurence
    public void delete(int key) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        if(head.data == key) {
            head = head.next;
            return;
        }
        Node temp = head;
        while(temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }
        if(temp.next == null) {
            System.out.println("Node is not present");
            return;
        }
        temp.next = temp.next.next;
    }
    //print the List
    public void print() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

}



public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
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