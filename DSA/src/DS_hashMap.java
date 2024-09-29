import java.util.*;

public class DS_hashMap {
    public static void main(String[] args){
        // country (key) , population
        HashMap<String, Integer> map = new HashMap<>();

        // insertion
        map.put("Pakistan", 24);
        map.put("India", 125);
        map.put("France", 23);
        map.put("Germany", 22);
//
//        System.out.println(map);
//
//        map.put("Pakistan", 25);
//        System.out.println(map);

        // search
//        if(map.containsKey("India")){
//            System.out.println("key is present in the map");
//        }
//        else{
//            System.out.println("key is not present in the map");
//        }
//
//        System.out.println(map.get("India"));     // key exists
//        System.out.println(map.get("Fran"));      // key doesn't exists

        // A new type of for loop
//        int arr[] = {12, 15, 18};
//        for(int i = 0; i < 3; i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//
//        for(int val : arr){
//            System.out.print(val + " ");
//        }
//        System.out.println();

        // iterators in hashMap
        for(Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }

        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key + " - " + map.get(key));
        }
    }
}
