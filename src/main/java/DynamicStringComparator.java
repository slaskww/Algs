import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DynamicStringComparator implements DynamicAlg<String> {


    int[][] comparativeMatrix;
    private final List<String> wordListToCompare;
    private final String chosenWord;

    public DynamicStringComparator(List<String> wordListToCompare, String chosenWord) {

        this.chosenWord = chosenWord;
        this.wordListToCompare = wordListToCompare;
    }

    @Override
    public Set<String> findOptimalContents() {

        if(chosenWord.equals( "" )) throw new IllegalArgumentException("Chosen word must not be empty");
        if(wordListToCompare.isEmpty()) throw new IllegalArgumentException("List of similar words must not be empty");


        Set<String> bestMatchedWords = new HashSet<>();
        int bestMatchingValue = 0;

        for(String wordToCompare: wordListToCompare){

            if(!wordToCompare.equals( "" )){

                int rows = chosenWord.length();
                int cols = wordToCompare.length();

                comparativeMatrix = new int[rows][cols];

                for(int i = 0; i < rows; i++){


                    for(int j = 0; j < cols; j++){

                        char rowChar = chosenWord.charAt( i );
                        char columnChar = wordToCompare.charAt( j );
                        int currentTableElementValue = 0;

                        if(rowChar == columnChar) currentTableElementValue = 1 + getElementValue(i -1, j-1);
                        else currentTableElementValue = maxValue(getElementValue(i, j-1), getElementValue(i -1, j));

                        comparativeMatrix[i][j] = currentTableElementValue;
                    }

                }
                if (comparativeMatrix[rows -1][cols -1] > bestMatchingValue){
                    bestMatchedWords = new HashSet<String>(){{add( wordToCompare );}};
                }

            }
        }
        return bestMatchedWords;
    }

    private int getElementValue(int row, int column){

        if(row < 0 || column < 0) return 0;
        else return comparativeMatrix[row][column];
    }

    private int maxValue(int a, int b){

        return Math.max( a, b );

    }

}
