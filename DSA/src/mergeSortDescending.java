
public class mergeSortDescending {
    public static void conquer(int arr[], int sI, int mid, int eI){
        int mergedArray[] = new int[eI - sI + 1];

        int index1 = sI;               // to track first array
        int index2 = mid+1;            // to track second array
        int x = 0;                     // index of mergedArray

        while(index1 <= mid && index2 <= eI){
            if(arr[index1] <= arr[index2]){
                mergedArray[x++] = arr[index2++];
            }
            else{
                mergedArray[x++] = arr[index1++];
            }
        }

        while(index1 <= mid){
            mergedArray[x++] = arr[index1++];
        }

        while(index2 <= eI){
            mergedArray[x++] = arr[index2++];
        }

        for(int i = 0, j = sI; i < mergedArray.length; i++, j++){
            arr[j] = mergedArray[i];
        }
    }

    public static void divide(int arr[], int sI, int eI){
        if(sI >= eI){
            return;
        }

        int mid = (sI + eI) / 2;
        divide(arr, sI, mid);
        divide(arr, mid + 1, eI);

        conquer(arr, sI, mid, eI);
    }

    public static void main(String[] args){
        int arr[] = {8, 4, 6, 1, 2, 9};
        int n = arr.length;

        divide(arr, 0, n-1);

        // to print the sorted array
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
