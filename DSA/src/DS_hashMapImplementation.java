import java.util.*;

public class DS_hashMapImplementation {
    static class HashMap<K, V> {   // generics       // HashMap Data Structure
        private class Node {
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;   // number of nodes of linkedList
        private int N;   // array length / buckets
        private LinkedList<Node> buckets[];   // N = buckets.length

        public HashMap(){
            this.N = 4;   // total no. of buckets
            this.buckets = new LinkedList[N];
            for(int i = 0; i < N; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){  // 0 to N - 1
            int bucketIndex = key.hashCode();
            return Math.abs(bucketIndex) % N;  // mode of vale / to make -ve value +ve
        }
        private int searchInLinkedList(K key, int bucketIndex){
            LinkedList<Node> ll  = buckets[bucketIndex];

            for(int i = 0; i < ll.size(); i++){
                if(ll.get(i).key == key){
                    return i; //  i is dataIndex
                }
            }

            return -1;
        }
        private void reHash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];

            for(int i = 0;  i < N * 2; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i = 0; i < oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j = 0; j < ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value){
           int bucketIndex = hashFunction(key);
           int dataIndex = searchInLinkedList(key, bucketIndex);

           if(dataIndex == -1){ // key doesn't exist
                buckets[bucketIndex].add(new Node(key, value));
                n++;
           }
           else{ // key exists
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
           }

           double lambda = (double)n/N;
           if(lambda > 2.0){
               // re-hashing
               reHash();
           }
        }

        public boolean containsKey(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if(dataIndex == -1){ // key doesn't exists
                return false;
            }
            else{ // key exists
                return true;
            }
        }

        public V remove(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if(dataIndex == -1) { // key doesn't exists
                return null;
            }
            else{ // key exists
                Node node = buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.value;
            }
        }

        public V get(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if(dataIndex == -1){ // key doesn't exist
                return null;
            }
            else{ // key exists
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i = 0; i < buckets.length; i++){ // bucketIndex
                LinkedList<Node> ll = buckets[i];
                for(int j = 0; j <ll.size(); j++){ // dataIndex
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }
    }

    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Pakistan", 30);
        map.put("India", 125);
        map.put("United States", 35);

        ArrayList<String> keys = map.keySet();

        for(int i = 0; i < keys.size(); i++) {
            System.out.print(keys.get(i) + " - " + map.get(keys.get(i)));
            System.out.println();
        }

        map.remove("India");
        System.out.println(map.get("India"));
    }
}
