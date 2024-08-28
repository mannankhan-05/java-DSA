
public class insertionSortDescending {
    public static void main(String[] args){
        int arr[] = {3, 5, 4, 1, 8, 7};

        // insertion sort for descending order
        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i - 1;

            while(j >= 0 && current > arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }

            // placement
            arr[j + 1] = current;
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
