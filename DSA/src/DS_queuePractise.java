public class DS_queuePractise {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null & tail == null;
        }

        // enque
        public static void add(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        // deque
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int front = head.data;
            if(head == tail){
                tail = null;
            }
            head = head.next;

            return front;
        }

        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args){
        DS_queuePractise.Queue queue = new DS_queuePractise.Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        while(!queue.isEmpty()){
            System.out.print(queue.peek() + " ");
            queue.remove();
        }
    }
}
