import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Data
public class DynamicAlgBackpack implements DynamicAlg<DynamicAlgBackpack.Artefact>{

    private  TableElement[][] backpack;
    private  List<Artefact> artefacts;
    private  int backpackCapacity;

    public DynamicAlgBackpack(List<Artefact> artefacts, int backpackCapacity) {
        this.artefacts = artefacts;
        this.backpackCapacity = backpackCapacity;

        initializeBackpack(artefacts.size(), backpackCapacity);
    }

    @Override
    public List<Artefact> findBest() {

        if(backpackCapacity <= 0 ) throw new IllegalArgumentException("Backpack capacity value must be positive");
        if(artefacts.isEmpty()) throw new IllegalArgumentException("Number of artifacts cannot be zero");


        for(int i = 0; i < artefacts.size(); i++){

            Artefact currentArtefact = artefacts.get( i );
            String currArtefName = currentArtefact.getName();
            int currArtefValue = currentArtefact.getValue();
            int currArtefWeight = currentArtefact.getWeight();


            for (int j = 0; j < backpackCapacity; j++){

                int currTableElementValue;
                List<Artefact>  currTableElementArtefactsList;
                int lastMaxTableElementValue = getPreviousMaxTableValue(i - 1, j);

                if(currArtefWeight > j + 1) {
                    currTableElementValue = 0;
                    currTableElementArtefactsList = new ArrayList<>();
                } else{
                    currTableElementValue = currArtefValue;
                    currTableElementArtefactsList = new ArrayList<Artefact>(){{add( currentArtefact );}};
                }

                currTableElementValue += getPreviousMaxTableValue( i - 1, j - currArtefWeight );

                if (lastMaxTableElementValue > currTableElementValue){

                    backpack[i][j] = backpack[i-1][j];
                } else{

                    currTableElementArtefactsList.addAll(getPreviousMaxTableArtefList(i - 1, j - currArtefWeight)  );
                    backpack[i][j] = new TableElement(currTableElementValue, currTableElementArtefactsList);
                }



              //  backpack[i][j] = getMax()
            }
        }

        return backpack[artefacts.size() - 1][backpackCapacity - 1].getArtefacts();
    }

    private int getPreviousMaxTableValue(int row, int col){

        if(row < 0 || col < 0) return 0;

        return backpack[row][col].getValue();
    }

    private List<Artefact>  getPreviousMaxTableArtefList(int row, int col){
        if(row < 0 || col < 0) return Collections.emptyList();

        return backpack[row][col].getArtefacts();
    }

    @Data
    static class Artefact{

        public Artefact(String name, int value, int weight) {

            this.name = name;
            this.value = value;
            this.weight = weight;

        }

        private String name;
        private int value;
        private int weight;

        public int getValue() {

            if(this.value <= 0) throw new IllegalArgumentException("Value of artefact cannot be zero nor negative");
            return value;
        }

        public int getWeight() {
            if(this.weight <= 0) throw new IllegalArgumentException("Weight of artefact cannot be zero nor negative");
            return weight;
        }
    }

    @Data
    @AllArgsConstructor
    static class TableElement{

        private int value;
        private List<Artefact> artefacts;
    }

    private void initializeBackpack(int rows, int cols){

        if(cols < 0) cols = 0;
        this.backpack = new TableElement[rows][cols];

    }

}
