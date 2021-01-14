import java.util.Arrays;


public class Quicksort {


    public static int[] sortArray(int[] array, int start, int end) {

        if (array.length < 2) {
            return array;

        }
        int pivotIndex = partition( array, start, end );
        int pivot = array[pivotIndex];
        int[] left =  sortArray( Arrays.copyOfRange( array, start, pivotIndex), start, pivotIndex - 1 );
        int[] arrr = Arrays.copyOfRange( array, pivotIndex + 1, end + 1);
        int[] right =  sortArray(arrr , 0, arrr.length - 1);
        int[] res = concate(left, pivot ,right);
        return res;

    }

    private static int partition(int[] array, int start, int end){

        if(start == end) return start;

        int pivot = array[end];
        int pIndex = start;

        for(int i = start; i <= end - 1; i++){
            if(array[i] <= pivot){
                int curr = array[i];
                array[i] = array[pIndex];
                array[pIndex] = curr;
                pIndex++;
            }

        }

        int curr = array[end];
        array[end] = array[pIndex];
        array[pIndex] = curr;


    return pIndex;
    }

    public static int[] concate(int[] a,int p ,int[] b){


        int len = a.length + b.length + 1;
        int[] tempArr = new int[len];
        if (a.length > 0){
            for (int i = 0; i < a.length; i++){
                tempArr[i] = a[i];
            }
        }


        tempArr[a.length] = p;

        if (b.length > 0){
            for (int i = a.length + 1, j = 0; i < tempArr.length; i++, j++ ){
                tempArr[i] = b[j];
            }
        }

        return tempArr;
    }
}
