import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class DS_hashMapPractisee {
    public static void main(String[] args) {
        HashMap<Integer, String> name = new HashMap<>();

        name.put(1, "Abdul Mannan Khan");
        name.put(2, "Anorag Joshi");
        name.put(3, "Saqlain bhai");
        System.out.println("size of HashMap is : " + name.size());

        name.remove(2);
        System.out.println("size of HashMap is : " + name.size());

        for(Map.Entry<Integer, String> entry : name.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
