import java.util.*;
// Q1 : find the nth node from the LinkedList and delete it from the List.
// Q2 : find that if the LinkedList is palindrome or not.
public class DS_linkedList3ImpQues {
    Node head;
    class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public void addFirst(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList(){

        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.val + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // Q1:
    public Node nthNode(Node head, int val){
        if(head.next == null){
            return null;
        }

        int size = 0;
        Node curr = head;
        while(curr != null){
            curr = curr.next;
            size++;
        }

        if(val == size){
            return head.next;
        }

        int indexToSearch = size - val;
        Node prev = head;
        int i = 1;
        while(i < indexToSearch){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }

    //Q2:
    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }

        Node middle = findMiddle(head);             // 1st half ka end
        Node secondHalfStart = reverse(middle.next);

        Node firstHalfStart = head;
        while(secondHalfStart != null){
            if(firstHalfStart.val != secondHalfStart.val){
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }

        return true;
    }

    public Node reverse(Node head){
        Node prev = null;
        Node curr  = head;

        while(curr != null){
            Node next  = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public Node findMiddle(Node head){
        Node hare = head;
        Node turtle = head;

        while(hare.next != null && hare.next.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
    }

    public static void main(String[] args) {
        DS_linkedList3ImpQues list = new DS_linkedList3ImpQues();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);

        list.printList();

//        list.nthNode(list.head, 2);
//        list.printList();

        list.isPalindrome(list.head);
        list.printList();
    }
}
