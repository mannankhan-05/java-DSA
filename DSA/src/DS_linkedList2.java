import java.util.*;

public class DS_linkedList2 {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("b");
        list.addFirst("a");
        list.add("c");
        System.out.println(list);

        System.out.println(list.size());

//        list.removeFirst();
//        list.removeLast();

        list.remove(0);

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
