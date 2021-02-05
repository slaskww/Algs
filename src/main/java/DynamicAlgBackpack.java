import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


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


        return null;
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
    static class TableElement{

        private int value;
        private List<Artefact> artefacts;
    }

    private void initializeBackpack(int rows, int cols){

        if(cols < 0) cols = 0;
        this.backpack = new TableElement[rows][cols];

    }

}
