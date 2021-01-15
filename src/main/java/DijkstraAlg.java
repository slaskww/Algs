import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class DijkstraAlg {


    public static void main(String[] args) {


        Map<String, GraphNode> graph = new HashMap<String, GraphNode>(  ){{
            put("A", new GraphNode( "A", new HashMap<String, Integer>(  ){{
                put( "B", 3 );
                put( "C", 1 );
            }} )  );
            put("B", new GraphNode( "B", new HashMap<String, Integer>(  ){{
                put( "E", 6 );
            }} )  );
            put("C", new GraphNode( "C", new HashMap<String, Integer>(  ){{
                put( "D", 5 );
            }} )  );
            put("D", new GraphNode( "D", new HashMap<String, Integer>(  ){{
                put( "B", 1 );
                put( "E", 2 );
            }} ) );
            put( "E", new GraphNode( "E", Collections.emptyMap() ));
        }};

        List<String> fastestRoute = new ArrayList<>(  );
        fastestRoute =  findFastestRoute("A", graph);
        System.out.println(fastestRoute.toString());



    }


    public static List<String> findFastestRoute(String startNode, Map<String, GraphNode> graph){

        return Arrays.asList( "A", "B", "C" );
    }

    @Data
    static class GraphNode{

        private String id;
        private Map<String, Integer> friends;

        public GraphNode(String id, Map<String, Integer> friends){
            this.friends = friends;
            this.id = id;
        }
    }
}
