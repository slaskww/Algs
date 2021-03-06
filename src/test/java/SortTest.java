import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    @Test
    public void testEmptyArray() {

        int[] arr = new int[]{};
        int[] sortedArr = Quicksort.sortArray( arr, 0, arr.length - 1);

        assertArrayEquals( sortedArr, new int[]{} );
    }


    @Test
    public void testOneRowArray(){

        int[] arr = new int[]{1};
        int[] sortedArr = Quicksort.sortArray( arr, 0, arr.length - 1);

        assertArrayEquals( sortedArr, new int[]{1} );
    }

    @Test
    public void testTwoRowArray(){

        int[] arr = new int[]{7,3};
        int[] sortedArr = Quicksort.sortArray( arr, 0, arr.length - 1);

        assertArrayEquals( sortedArr, new int[]{3,7} );
    }

    @Test
    public void testThreeRowArray(){

        int[] arr = new int[]{7, 3, 8};
        int[] sortedArr = Quicksort.sortArray( arr, 0, arr.length - 1);

        assertArrayEquals( sortedArr, new int[]{3,7, 8} );
    }

    @Test
    public void testSevenRowArray(){

        int[] arr = new int[]{7, 3, 1, 2, 6, 4, 5};
        int[] sortedArr = Quicksort.sortArray( arr, 0, arr.length - 1);

        assertArrayEquals( sortedArr, new int[]{1, 2, 3, 4, 5, 6, 7} );
    }


    @Test
    public void testTwentyRowArray(){

        int[] arr = new int[]{1, 19, 2 ,18, 3, 17, 4 ,5 ,16, 15 ,10, 6 ,8 ,9 ,7 , 14 ,13 ,12 ,11, 0};
        int[] sortedArr = Quicksort.sortArray( arr, 0, arr.length - 1);

        assertArrayEquals( sortedArr, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19} );
    }

    @Test
    public void testSixRowArrayFilledWithOneAndTwo(){

        int[] arr = new int[]{1, 2, 1, 2, 1, 2};
        int[] sortedArr = Quicksort.sortArray( arr, 0, arr.length - 1);

        assertArrayEquals( sortedArr, new int[]{1, 1, 1, 2, 2, 2} );
    }

    @Test
    public void testSixRowArrayFilledWithOne(){

        int[] arr = new int[]{1, 1, 1, 1, 1, 1};
        int[] sortedArr = Quicksort.sortArray( arr, 0, arr.length - 1);

        assertArrayEquals( sortedArr, new int[]{1, 1, 1, 1, 1, 1} );
    }
}
