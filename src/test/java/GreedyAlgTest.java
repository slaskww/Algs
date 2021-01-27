import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class GreedyAlgTest {

    private static Map<String, GreedyAlg.USState> uSStatesMap;

@BeforeAll
    public static void createMapOfStates(){

    uSStatesMap = new HashMap<String, GreedyAlg.USState>(){{
        put("Waszyngton", new GreedyAlg.USState("Waszyngton", new HashSet<String>(){{addAll( Arrays.asList("Oregon", "Idaho"));}}));
        put("Oregon", new GreedyAlg.USState("Oregon", new HashSet<String>(){{addAll( Arrays.asList("Waszyngton", "Kalifornia", "Idaho", "Nevada" ));}}));
        put("Kalifornia", new GreedyAlg.USState("Kalifornia", new HashSet<String>(){{addAll( Arrays.asList("Oregon", "Arizona", "Nevada" ));}}));
        put("Idaho", new GreedyAlg.USState("Idaho", new HashSet<String>(){{addAll( Arrays.asList("Waszyngton", "Oregon", "Nevada", "Utah", "Montana", "Wyoming" ));}}));
        put("Nevada", new GreedyAlg.USState("Nevada", new HashSet<String>(){{addAll( Arrays.asList("Oregon", "Kalifornia", "Idaho", "Utah", "Arizona" ));}}));
        put("Montana", new GreedyAlg.USState("Montana", new HashSet<String>(){{addAll( Arrays.asList("Wyoming", "Idaho"));}}));
        put("Wyoming", new GreedyAlg.USState("Wyoming", new HashSet<String>(){{addAll( Arrays.asList("Montana", "Idaho", "Utah", "Kolorado" ));}}));
        put("Utah", new GreedyAlg.USState("Utah", new HashSet<String>(){{addAll( Arrays.asList("Idaho", "Nevada", "Arizona", "Nowy Meksyk", "Kolorado", "Wyoming" ));}}));
        put("Arizona", new GreedyAlg.USState("Arizona", new HashSet<String>(){{addAll( Arrays.asList("Kalifornia", "Nevada", "Utah", "Kolorado", "Nowy Meksyk"  ));}}));
        put("Kolorado", new GreedyAlg.USState("Kolorado", new HashSet<String>(){{addAll( Arrays.asList("Wyoming", "Utah", "Arizona", "Nowy Meksyk"  ));}}));
        put("Nowy Meksyk", new GreedyAlg.USState("Nowy Meksyk", new HashSet<String>(){{addAll( Arrays.asList("Utah", "Arizona", "Kolorado"));}}));

    }};

}

@Test
    public void testFillingEmptyMap(){

  //  uSStatesMap.forEach( (s, usState) -> log.info( s + "\n" + usState.getNeighboursStates().stream().collect( Collectors.joining("\n") ) ) );
}

@Test
    public void testFillingElevenElementMap(){

}

}
