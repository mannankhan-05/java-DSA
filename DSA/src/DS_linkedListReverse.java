//import java.util.*;

public class DS_linkedListReverse {
    Node head;
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        // if the LinkedList is empty
        if(head == null){
            head = newNode;
            return;
        }

        // sets the next pointer of the new node (newNode) to the current head of the linked list
        newNode.next = head;
        // This line makes the new node the new head of the linked list
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }

        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("LinkedList is empty.");
            return;
        }

        head = head.next;
     }

    public void deleteLast(){
        if(head == null){
            System.out.println("LinkedList is empty.");
            return;
        }
        if(head.next  == null){
            head = null;
            return;
        }

       Node secondLastNode = head;
       Node lastNode = head.next;

       while(lastNode.next != null){
           secondLastNode = secondLastNode.next;
           lastNode = lastNode.next;
       }
       secondLastNode.next = null;
    }

    public void printList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // iterative way of reversing a LinkedList
    public void reverseIterate(){
        if(head == null || head.next == null){
            return;
        }

        Node prevNode = head;         // points to the 1st node.
        Node currNode = head.next;    // points to the 2nd node

        while(currNode != null){
            Node nextNode = currNode.next;      // saves the 3rd node.
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        DS_linkedListReverse list = new DS_linkedListReverse();

        list.addFirst(1);
        list.addFirst(0);
        list.addLast(2);

        list.printList();

        list.reverseIterate();
        list.printList();

        list.head = list.reverseRecursive(list.head);
        list.printList();
    }
}
