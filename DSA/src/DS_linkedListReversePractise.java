
public class DS_linkedListReversePractise {
    NodeList head;

    class NodeList{
        int value;
        NodeList next;

        NodeList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // addFirst
    public void addFirst(int value){
        NodeList newNode = new NodeList(value);
        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // print LinkedList
    public void printList(){
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }

        NodeList currNode = head;
        while(currNode != null){
            System.out.print(currNode.value + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // reverse LinkedList : method1
    public void reverseList(){
        if(head == null || head.next == null){
            return;
        }

        NodeList prevNode = head;
        NodeList currNode = head.next;
        while(currNode != null){
            NodeList nextNode = currNode.next;
            currNode.next =  prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    // reverse LinkedList : method2
    public NodeList reverseLinkedList(NodeList head){
        if(head == null || head.next == null){
            return head;
        }

        NodeList newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        DS_linkedListReversePractise list = new DS_linkedListReversePractise();

        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.printList();

//        System.out.println("reversing LinkedList using 1st method :");
//        list.reverseList();
//        list.printList();

        System.out.println();

        System.out.println("reversing LinkedList using 2nd method :");
        list.head = list.reverseLinkedList(list.head);
        list.printList();
    }
}
