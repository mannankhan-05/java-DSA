// stack practise question : to add the element at the bottom of the stack

import java.util.Stack;
//public class stackPractise {
//    public static void addBottom(Stack<Integer> list, int value){
//        if(list.isEmpty()){
//            list.push(value);
//            return;
//        }
//
//        int top = list.peek();
//        list.pop();
//        addBottom(list, value);
//        list.push(top);
//    }
//
//    public static void main(String[] args){
//        Stack<Integer> list = new Stack<>();
//        list.push(1);
//        list.push(2);
//        list.push(3);
//        list.push(4);
//
//        addBottom(list, 10);
//
//        while(!list.isEmpty()){
//            System.out.println(list.peek() + " ");  // to print the top element of the stack
//            list.pop();    // to remove the top element of the stack
//        }
//    }
//}








// stack question practise : to reverse the stack
class stackPractise{
    public static void pushAtBottom(Stack<Integer> list, int value){
        if(list.isEmpty()){
            list.push(value);
            return;
        }

       int top = list.peek();
       list.pop();
       pushAtBottom(list,value);
       list.push(top);
    }

    public static void reverseStack(Stack<Integer> list){
        if(list.isEmpty()){
            return;
        }

        int top = list.peek();
        list.pop();
        reverseStack(list);
       pushAtBottom(list, top);
    }

    public static void main(String[] args){
        Stack<Integer> list = new Stack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);

        reverseStack(list);

        while(!list.isEmpty()){
            System.out.println(list.peek() + " ");  // to print the top element of the stack
            list.pop();    // to remove the top element of the stack
        }
    }
}