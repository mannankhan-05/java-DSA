
public class selectionSortAscending {
    public static void main(String[] args){
        int arr[] = {3, 5, 1, 2, 9, 4};

        // selection sort for ascending order
        for(int i = 0; i < arr.length - 1; i++){
            int smallest = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
