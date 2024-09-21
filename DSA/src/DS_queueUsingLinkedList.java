
public class DS_queueUsingLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;


        public static boolean isEmpty() {
            return head == null & tail == null;
        }


        // enque -- add
        public static void add(int data) {
           Node newNode = new Node(data);
            if(tail == null){
                tail = head = newNode;
                return;
            }
           tail.next = newNode;
           tail = newNode;
        }

        // deque -- remove -- O(n)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            int front = head.data;
            if(head == tail){
                tail = null;
            }
            head = head.next;

            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args){
        DS_queueUsingArray.Queue q = new DS_queueUsingArray.Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);


        while(!q.isEmpty()){
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();
    }
}
