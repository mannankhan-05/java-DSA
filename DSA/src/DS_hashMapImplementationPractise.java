import java.util.*;

public class DS_hashMapImplementationPractise {
    static class HashMap<K, V> {  // generics
        private class Node {
            K key;
            V value;

            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;  // no. of nodes in linkedList
        private int N;  // size of array
        private LinkedList<Node> buckets[];

        private HashMap(){
            this.N = 4;  // total no. of buckets / size of array
            this.buckets = new LinkedList[N];
            for(int i = 0; i < N; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int bucketIndex = key.hashCode();
            // Math.abs --> returns non-negative value   &&    range of bucketIndex is 0 to n - 1
            return Math.abs(bucketIndex) % N;
        }

        private int searchInLinkedList(K key, int bucketIndex){
            LinkedList<Node> LL = buckets[bucketIndex];

            for(int i = 0; i < LL.size(); i++){
                if(LL.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }

        private void reHash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i = 0; i < N * 2; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i = 0; i < oldBucket.length; i++){
                LinkedList<Node> LL = oldBucket[i];
                for(int j = 0; j < LL.size(); j++){
                    Node node = LL.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if(dataIndex == -1){  // key doesn't exist
                buckets[bucketIndex].add(new Node(key, value));
                n++;
            }
            else{
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0){
                reHash();
            }
        }

        public V get(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if(dataIndex == -1){  // key doesn't exist
                return null;
            }
            else{ // key exists
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }
        }

        public V remove(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);

            if(dataIndex == -1){ // key doesn't exist
                return null;
            }
            else{ // key exists
                Node node = buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.value;
            }
        }

        public ArrayList<K> getKeys(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i = 0; i < buckets.length; i++){
                LinkedList<Node> LL = buckets[i];

                for(int j = 0; j < LL.size(); j++){
                    Node node = LL.get(j);
                    keys.add(node.key);
                }
            }

            return keys;
        }
    }

    public static void main(String[] args){
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");

        ArrayList<Integer> keys = map.getKeys();

        for(int i = 0; i < keys.size(); i++){
            System.out.print(keys.get(i) + " - " + map.get(keys.get(i)));
            System.out.println();
        }
        System.out.println();

        map.remove(3);
        for(int i = 0; i < keys.size(); i++){
            System.out.print(keys.get(i) + " - " + map.get(keys.get(i)));
            System.out.println();
        }
    }
}
