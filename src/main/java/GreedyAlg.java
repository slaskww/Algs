import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class GreedyAlg {

    public static Map<String, Set<String>> fillMapOfUSStatesWithColor(Map<String, USState> uSStates){

        return Collections.emptyMap();
    }

    @Data
    @AllArgsConstructor
    public static class USState{

        private String name;
        private Set<String> neighboursStates;
    }
}
