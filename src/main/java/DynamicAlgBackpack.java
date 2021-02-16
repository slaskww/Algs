import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Data

public class DynamicAlgBackpack implements DynamicAlg<DynamicAlgBackpack.Artefact>{

    private  BackpackElement[][] backpack;
    private  List<Artefact> artefacts;
    private  int backpackCapacity;
    private double resolutionValue;
    private int backpackResolution;

    public DynamicAlgBackpack(List<Artefact> artefacts, int backpackCapacity) {
        this.artefacts = artefacts;
        this.backpackCapacity = backpackCapacity;
        this.resolutionValue = 1;
        this.backpackResolution = backpackCapacity;

        initializeBackpack(artefacts.size(), (backpackCapacity));
    }

    public DynamicAlgBackpack(List<Artefact> artefacts, int backpackCapacity, double resolutionValue) {
        this.artefacts = artefacts;
        this.backpackCapacity = backpackCapacity;
        this.resolutionValue = resolutionValue;
        this.backpackResolution =  (int) (backpackCapacity/resolutionValue);

        initializeBackpack(artefacts.size(), (int) (backpackCapacity / resolutionValue));
    }

    @Override
    public Set<Artefact> findOptimalContents() {

        if(backpackCapacity <= 0 ) throw new IllegalArgumentException("Backpack capacity value must be positive");
        if(artefacts.isEmpty()) throw new IllegalArgumentException("Number of artifacts cannot be zero");

        artefacts.forEach( artefact -> {
            if(artefact.weight % 0.5 != 0) throw new IllegalArgumentException("Artifact weight must be an integer or a decimal number divisible by 0.5");

        } );

        for(int i = 0; i < artefacts.size(); i++){

            Artefact currentArtefact = artefacts.get( i );
            int currentArtefactValue = currentArtefact.getValue();
            double currentArtefactWeight = currentArtefact.getWeight() / resolutionValue;
            int currentBackpackElementValue;
            Set<Artefact> currentBackpackElementSetOfArtefacts;


            for (int j = 0; j < backpackResolution; j++){

                if(currentArtefactWeight > j + 1) {
                    currentBackpackElementValue = 0;
                    currentBackpackElementSetOfArtefacts = new HashSet<>();
                } else{
                    currentBackpackElementValue = currentArtefactValue;
                    currentBackpackElementSetOfArtefacts = new HashSet<Artefact>(){{add( currentArtefact );}};
                }

                //We assume that the default local maximum value for the current element "backpack[i][j]" in the specified column "j" is above that element (backpack[i-1][j])
                int localMaxBackpackElementValue = getSpecifiedBackpackElementValue(i - 1, j);

                //The current element 'backpack[i][j]' of the backpack contains the current artifact, and the remaining capacity can be filled with the contents of the element backpack[i-1][j-current artefact weight]
                currentBackpackElementValue += getSpecifiedBackpackElementValue( i - 1, j - (int) currentArtefactWeight );
                currentBackpackElementSetOfArtefacts.addAll( getSpecifiedBackpackElementSetOfArtefacts(i - 1, j - (int) currentArtefactWeight));


                //We compare the value of the current backpack element 'backpack[i][j]' to the value of the default local maximum for the current column 'j'
                //The higher value will be the final value of the backpack element "backpack[i][j]"
                if (localMaxBackpackElementValue > currentBackpackElementValue){
                    backpack[i][j] = backpack[i-1][j];
                } else{
                    backpack[i][j] = new BackpackElement(currentBackpackElementValue, currentBackpackElementSetOfArtefacts);
                }

            }
        }

        printBackpack();

        return backpack[artefacts.size() - 1][backpackResolution - 1].getArtefacts();
    }

    private int getSpecifiedBackpackElementValue(int row, int col){

        if(row < 0 || col < 0) return 0;

        return backpack[row][col].getValue();
    }

    private Set<Artefact> getSpecifiedBackpackElementSetOfArtefacts(int row, int col){
        if(row < 0 || col < 0) return Collections.emptySet();

        return backpack[row][col].getArtefacts();
    }


    @Data
    static class Artefact{

        public Artefact(String name, int value, double weight) {

            this.name = name;
            this.value = value;
            this.weight = weight;

        }

        private String name;
        private int value;
        private double weight;

        public int getValue() {

            if(this.value <= 0) throw new IllegalArgumentException("Value of artefact cannot be zero nor negative");
            return value;
        }

        public double getWeight() {
            if(this.weight <= 0) throw new IllegalArgumentException("Weight of artefact cannot be zero nor negative");
            return weight;
        }
    }

    @Data
    @AllArgsConstructor
    static class BackpackElement {

        private int value;
        private Set<Artefact> artefacts;
    }

    private void initializeBackpack(int rows, int cols){

        if(cols < 0) cols = 0;
        this.backpack = new BackpackElement[rows][cols];

    }

    public void printBackpack(){

        StringBuilder builder = new StringBuilder();
        builder.append( "\n" );

        for (BackpackElement[] backpackElements : backpack) {

            for (BackpackElement backpackElement : backpackElements) {

                builder
                        .append( "[" )
                        .append( backpackElement.getArtefacts()
                            .stream()
                            .map( artefact -> artefact.name )
                            .collect( Collectors.joining( ", " ) ) )
                        .append( "]" );
            }
            builder.append( "\n" );
        }

        log.info( builder.toString() );
    }
}
