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

        backpack = new TableElement[artefacts.size()][backpackCapacity];
    }

    @Override
    public List<Artefact> findBest() {

        return null;
    }

    @Data
    static class Artefact{

        private String name;
        private int value;
        private int weight;
    }

    @Data
    static class TableElement{

        private int value;
        private List<Artefact> artefacts;
    }

}
