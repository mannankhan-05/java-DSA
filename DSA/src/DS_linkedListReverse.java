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

    public static void main(String[] args) {
        DS_linkedListReverse list = new DS_linkedListReverse();

        list.addFirst(1);
        list.addFirst(0);
        list.addLast(2);

        list.deleteFirst();
        list.printList();
    }
}
