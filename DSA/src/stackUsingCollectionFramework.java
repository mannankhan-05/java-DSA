// implementing stack using java collection framework

import java.util.Stack;
public class stackUsingCollectionFramework {
    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
    }
}
