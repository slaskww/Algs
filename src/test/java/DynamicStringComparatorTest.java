import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicStringComparatorTest {

    @Test
    public void shouldMethodWithoutWordsToCompareThrowException(){

        List emptyList = Collections.EMPTY_LIST;
        DynamicStringComparator comparator = new DynamicStringComparator(emptyList, "mahesty");

        assertThrows(IllegalArgumentException.class, () -> comparator.findOptimalContents());

    }

    @Test
    public void shouldMethodWithoutChosenWordThrowException(){

        List<String> wordsToCompare = Arrays.asList("magenta", "modesty", "majesty");
        DynamicStringComparator comparator = new DynamicStringComparator( wordsToCompare, "" );

        assertThrows( IllegalArgumentException.class, () -> comparator.findOptimalContents() );
    }

    @Test
    public void testMethodWithGivenWordsToCompareAndChosenWord(){

        List<String> wordsToCompare = Arrays.asList("magenta", "modesty", "majesty");
        DynamicStringComparator comparator = new DynamicStringComparator( wordsToCompare, "mahesty" );

        assertEquals( new HashSet<String>(){{add("majesty" );}}, comparator.findOptimalContents() );
    }
}
