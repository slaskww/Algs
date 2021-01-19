import com.sun.deploy.cache.DeployCacheJarAccessImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DijkstraAlgTest {

    private static  Map<String, DijkstraAlg.GraphNode> graph;

    @BeforeAll
    public static void createGraph(){

             graph = new HashMap<String, DijkstraAlg.GraphNode>(  ){{
            put("A", new DijkstraAlg.GraphNode( "A", new HashMap<String, Integer>(  ){{
                put( "B", 3 );
                put( "C", 1 );
            }} )  );
            put("B", new DijkstraAlg.GraphNode( "B", new HashMap<String, Integer>(  ){{
                put( "D", 1 );
                put( "E", 6 );
            }} )  );
            put("C", new DijkstraAlg.GraphNode( "C", new HashMap<String, Integer>(  ){{
                put( "D", 5 );
            }} )  );
            put("D", new DijkstraAlg.GraphNode( "D", new HashMap<String, Integer>(  ){{
                put( "E", 2 );
            }} ) );
            put( "E", new DijkstraAlg.GraphNode( "E", Collections.emptyMap() ));
        }};
    }


    @Test
    public void testWithOneNodeGraph(){

        HashMap<String, DijkstraAlg.GraphNode> OneNodeGraph = new HashMap<String, DijkstraAlg.GraphNode>(  ){
            {put( "A", new DijkstraAlg.GraphNode( "A", Collections.emptyMap() ));}
        };
        List<String> route = DijkstraAlg.findShortestRoute( "A", "A", OneNodeGraph );
        assertArrayEquals(new String[]{"A"}, route.toArray());
    }

    @Test
    public void testWithEmptyGraph(){

        HashMap<String, DijkstraAlg.GraphNode> emptyGraph = new HashMap<String, DijkstraAlg.GraphNode>(  ){};

        List<String> route = DijkstraAlg.findShortestRoute( "A", "Z", emptyGraph );
        assertArrayEquals(new String[]{}, route.toArray());
    }

    @Test
    public void testWithGivenWrongStartNodeAndFinalNodeArguments(){

        assertThrows( IllegalArgumentException.class, () -> DijkstraAlg.findShortestRoute( "AA", "EE", graph ) );
    }

    @Test
    public void testWithFiveNodeGraph(){

        List<String> shortestRoute = DijkstraAlg.findShortestRoute( "A", "E", graph );
        assertArrayEquals( new String[]{"A", "B", "D", "E"}, shortestRoute.toArray() );

    }

}
