import java.util.HashSet;
import java.util.Iterator;

public class DS_hashSetPractise {
    public static void main(String[] args) {
        HashSet<Integer> list = new HashSet<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        list.remove(3);

        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.println("Size of HashSet is : " + list.size());

        if(list.contains(5)){
            list.remove(5);
        }
        else{
            System.out.println("List does not contain 5");
        }
    }
}
