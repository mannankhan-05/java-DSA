// practise of merge sort


public class mergeSortPractise {
    public static void conquer(int[] arr, int sI, int mid, int eI){

        int[] sortedArray = new int[eI - sI + 1];

        int idx1 = sI;   // to track first half of array
        int idx2 = mid + 1;   // to track second half of array
        int x = 0;   // to track sorted Array's index

        while(idx1 <= mid && idx2 <= eI){
            if(arr[idx1] < arr[idx2]){
                sortedArray[x] = arr[idx1];
                x++;
                idx1++;
            }
            else{
                sortedArray[x] = arr[idx2];
                x++;
                idx2++;
            }
        }

        while(idx1 <= mid){
            sortedArray[x] = arr[idx1];
            x++;
            idx1++;
        }

        while(idx2 <= eI){
            sortedArray[x] = arr[idx2];
            x++;
            idx2++;
        }

        for(int i = 0, j = sI; i < sortedArray.length; i++, j++){
            arr[j] = sortedArray[i];
        }
    }

    public static void divide(int[] arr, int sI, int eI){
        if(sI == eI){
            return;
        }

        int mid = (sI + eI)/2;
        divide(arr, sI, mid);
        divide(arr, mid + 1, eI);

        conquer(arr, sI, mid, eI);
    }

    public static void main(String[] args) {
        int arr[] = {8, 3, 2, 1, 3, 6, 4, 8, 7};
        int n = arr.length;

        divide(arr, 0, n-1);

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
