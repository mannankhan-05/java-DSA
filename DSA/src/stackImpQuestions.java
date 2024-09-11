// Q1 : push at the bottom of the stack

//import java.util.Stack;
//public class stackImpQuestions {
//    public static void pushAtBottom(int data, Stack<Integer> st){
//        if(st.isEmpty()){
//            st.push(data);
//            return;
//        }
//
//        int top = st.pop();
//        pushAtBottom(data, st);
//        st.push(top);
//    }
//
//    public static void main(String[] args){
//        Stack<Integer> st = new Stack<>();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//
//        stackImpQuestions.pushAtBottom(4, st);
//
//        while(!st.isEmpty()){
//            System.out.println(st.peek());
//            st.pop();
//        }
//    }
//}










// Q2 : reverse a stack

import java.util.Stack;
public class stackImpQuestions{
    public static void pushAtBottom(int data, Stack<Integer> st){
        if(st.isEmpty()){
            st.push(data);
            return;
        }

        int top = st.pop();
        pushAtBottom(data, st);
        st.push(top);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(top, s);
    }

    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        reverseStack(s);

        while(!s.isEmpty()){
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}
