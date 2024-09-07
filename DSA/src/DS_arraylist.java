import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class DS_arraylist {
    public static void main(String[] args) {
        // Integer | Float | String | Boolean          classes in java
        ArrayList<Integer> list = new ArrayList<>();

        // add elements
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.println(list);

        // get elements
        int element = list.get(1);
        System.out.println(element);

        // to add element in between
        list.add(1,4);
        System.out.println(list);

        // set element
        list.set(0, 6);
        System.out.println(list);

        // delete element
        list.remove(2);
        System.out.println(list);

        // size of arrayList
        int size = list.size();
        System.out.println(size);

        // loops
        for(int i = 0; i < size; i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // sorting in ArrayList
        Collections.sort(list);
        System.out.println(list);



        // String ArrayList
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add(1, "c");
        list2.set(0, "b");
        list2.remove(0);
        String b = list2.get(1);
        // System.out.println(b);
        System.out.println(list2);

        Collections.sort(list2);
        System.out.println(list2);
    }
}
