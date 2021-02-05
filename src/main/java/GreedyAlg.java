import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class GreedyAlg {

    public static Map<String, Set<String>> fillMapOfUSStatesWithColor(Map<String, USState> uSStates) {

        if (uSStates.isEmpty()) throw new IllegalArgumentException();


        Stack<String> colors = new Stack<String>() {
            {
                addAll( Arrays.asList( "red", "gray", "blue", "green", "purple", "orange", "yellow", "black", "white" ) );
            }
        };

        Map<String, Set<String>> mapOfColouredStates = new HashMap<>();
        Iterator<String> statesToProcess = uSStates.keySet().iterator();

        while (statesToProcess.hasNext()) {
            String processedState = statesToProcess.next();
            Set<String> neighboursOfProcessedState = uSStates.get( processedState ).getNeighboursStates();
            boolean isUsedNewColorToFillAState = true;

            if (mapOfColouredStates.isEmpty()) {
                mapOfColouredStates.put( colors.pop(), new HashSet<String>() {{
                    add( processedState );
                }} );
            } else {

                Iterator<Map.Entry<String, Set<String>>> mapOfColouredStatesIterator = mapOfColouredStates.entrySet().iterator();


                while (mapOfColouredStatesIterator.hasNext() && isUsedNewColorToFillAState) {
                    Map.Entry<String, Set<String>> mapOfColouredStatesEntry = mapOfColouredStatesIterator.next();

                    if (!checkIfStatesForCertainColorContainsNeighbours( mapOfColouredStatesEntry.getValue(), neighboursOfProcessedState )) {
                        Set<String> actualSetOfStatesForColor = mapOfColouredStatesEntry.getValue();
                        actualSetOfStatesForColor.add( processedState );

                        mapOfColouredStates.replace( mapOfColouredStatesEntry.getKey(), actualSetOfStatesForColor );
                        isUsedNewColorToFillAState = false;
                    }
                }

                if (isUsedNewColorToFillAState) {
                    mapOfColouredStates.put( colors.pop(), new HashSet<String>() {{
                        add( processedState );
                    }} );
                }
            }

        }

        mapOfColouredStates.forEach( (s, strings) -> log.info( s + "{" + strings.stream().collect( Collectors.joining( ", " ) ) + "}" ) );
        return mapOfColouredStates;

    }

    @Data
    @AllArgsConstructor
    public static class USState {

        private String name;
        private Set<String> neighboursStates;
    }

    private static boolean checkIfStatesForCertainColorContainsNeighbours(Set<String> statesForColor, Set<String> neighbours) {

        for (String neighbour : neighbours) {
            if (statesForColor.contains( neighbour )) return true;
        }
        return false;
    }
}
