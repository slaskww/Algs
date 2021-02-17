import java.util.List;
import java.util.Set;

public class DynamicStringComparator implements DynamicAlg<String> {


    private int[][] comparativeMatrix;
    private List<String> similarWords;
    private String chosenWord;

    public DynamicStringComparator(List<String> similarWords, String chosenWord) {

        this.chosenWord = chosenWord;
        this.similarWords = similarWords;
    }

    @Override
    public Set<String> findOptimalContents() {
        return null;
    }
}
