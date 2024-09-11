// implementing stack using LinkedList

public class stackUsingLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Stack {
        public static Node head;        // top of stack

        public static boolean isListEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if (isListEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            if(isListEmpty()){
                return -1;         // -1 represents that the stack is empty
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek(){
            if(isListEmpty()){
                return -1;         // -1 represents that the stack is empty
            }

            int top = head.data;
            return top;
        }
    }

    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isListEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
