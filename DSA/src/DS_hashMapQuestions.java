// Q1 : majority elements :

//import java.util.*;
//public class DS_hashMapQuestions {
//    public static void main(String[] args){
//        int arr[] = {1, 2};
//        int n = arr.length;
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for(int i = 0; i < n; i++){
//            if(map.containsKey(arr[i])){
//                // update the frequency
//                map.put(arr[i], map.get(arr[i]) + 1);
//            }
//            else{
//                // add the new key, value pair
//                map.put(arr[i], 1);
//            }
//        }
//
//        // check the given condition
//        for(int key : map.keySet()) {  // keySet function will return all the keys
//            if(map.get(key) > n/3) {
//                System.out.println("Majority Key is : " + key);
//            }
//        }
//    }
//}







// Q2 : Union of 2 arrays

//import java.util.*;
//public class DS_hashMapQuestions {
//    public static void main(String[] args){
//        int arr1[] = {7, 3, 9};
//        int arr2[] = {6, 3, 9, 2, 9, 4};
//
//        HashSet<Integer> union = new HashSet<>();
//
//        for(int  i = 0; i < arr1.length; i++){
//                union.add(arr1[i]);
//        }
//
//        for(int  i = 0; i < arr2.length; i++){
//                union.add(arr2[i]);
//            }
//
//        // printing the union hashSet
//        System.out.println("size of union hashSet : " + union.size());
//        System.out.println(union);
//    }
//}









// Q3 : intersection of 2 arrays

//import java.util.*;
//public class DS_hashMapQuestions {
//    public static void main(String[] args){
//        int arr1[] = {7, 3, 9};
//        int arr2[] = {6, 3, 9, 2, 9, 4};
//
//        HashSet<Integer> intersection = new HashSet<>();
//        int count = 0;
//
//        for(int i = 0; i < arr1.length; i++){
//            intersection.add(arr1[i]);
//        }
//
////        for(int i = 0; i < arr2.length; i++){
////            if(intersection.contains(arr2[i])){
////                count++;
////                intersection.remove(arr2[i]);
////            }
////        }
//
//        for(int num : arr2){
//            if(intersection.contains(num)){
//                count++;
//                intersection.add(num);
//            }
//            else{
//                intersection.remove(num);
//            }
//        }
//
//        System.out.println("intersection size : " + count);
//        System.out.println(intersection);
//    }
//}








// Q4 : find Itinerary from tickets (start se end tak ka path print karwana hai)

import java.util.*;
public class DS_hashMapQuestions {
    public static String getStart(HashMap<String, String> tick){
        HashMap<String, String> reverseMap = new HashMap<>();

        for(String key : tick.keySet()){
            reverseMap.put(tick.get(key), key);
        }

        for(String key : tick.keySet()){
            if(!reverseMap.containsKey(key)){
                return key;
            }
        }

        return null;
    }

    public static void main(String[] args) {
          HashMap<String, String> tickets = new HashMap<>();

          tickets.put("Chennai", "Bengaluru");
          tickets.put("Mumbai", "Delhi");
          tickets.put("Goa", "Chennai");
          tickets.put("Delhi", "Goa");

          String start = getStart(tickets);

          while(tickets.containsKey(start)){
              System.out.print(start + " -> ");
              start = tickets.get(start);
          }
        System.out.print(start);
    }
}
