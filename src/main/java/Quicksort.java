

import java.util.Arrays;


public class Quicksort {


    public static int[] sortArray(int[] array, int start, int end) {

        if (array.length < 2) {
            System.out.println("Array length is < 2" + ", length=" + array.length);
            return array;

        }
        System.out.println("start:" + start);
        int pivotIndex = partition( array, start, end );
        int pivot = array[pivotIndex];
        System.out.println("pivot index =" + pivotIndex);
        System.out.println("Left array=" + Arrays.toString( Arrays.copyOfRange( array, start, pivotIndex) ));
        int[] left =  sortArray( Arrays.copyOfRange( array, start, pivotIndex), start, pivotIndex - 1 );
        int[] arrr = Arrays.copyOfRange( array, pivotIndex + 1, end + 1);
        System.out.println("Right array=" + Arrays.toString( arrr ));
        int[] right =  sortArray(arrr , 0, arrr.length - 1);
        int[] res = concate(left, pivot ,right);
        return res;

    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 6, 1, 8, 7, 2, 3, 4};
        arr = sortArray( arr, 0, 7);

        System.out.println( "Array in main=" + Arrays.toString( arr ));

    }

    private static int partition(int[] array, int start, int end){

        if(start == end) return start;

        System.out.println("start ="+ start + " end=" + end);
        System.out.println("Array to sort=" + Arrays.toString( array ));
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

        System.out.println(Arrays.toString( array ));
        System.out.println("Returned pIndex="+pIndex );
    return pIndex;
    }

    public static int[] concate(int[] a,int p ,int[] b){

        System.out.println(">>Arrays before concate=" + Arrays.toString( a ) + " and " + Arrays.toString( b ));
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

        System.out.println(">>Arrays after concatenate=" + Arrays.toString( tempArr ));
        return tempArr;
    }
}
