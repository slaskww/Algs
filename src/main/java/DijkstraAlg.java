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
                put( "D", 1 );
                put( "E", 6 );
            }} )  );
            put("C", new GraphNode( "C", new HashMap<String, Integer>(  ){{
                put( "D", 5 );
            }} )  );
            put("D", new GraphNode( "D", new HashMap<String, Integer>(  ){{
                put( "E", 2 );
            }} ) );
            put( "E", new GraphNode( "E", Collections.emptyMap() ));
        }};

        List<String> fastestRoute;
        fastestRoute =  findShortestRoute("A", "E" , graph);
        log.info( "Shortest route: " + fastestRoute.toString());



    }


    public static List<String> findShortestRoute(String startNode, String finalNode , Map<String, GraphNode> graph){

        Deque<String> queueOfNodes = new ArrayDeque<>();
        queueOfNodes.addAll( graph.get( startNode ).friends.keySet() );


        Map<String, String> parents = new HashMap<>();
        parents.put( "A", "None" );


        Map<String, Integer> distances = new HashMap<>();
        distances.put( "A", 0 );

        graph.get( "A" ).friends.entrySet().stream().forEach( stringIntegerEntry -> {
            parents.put( stringIntegerEntry.getKey(), "A" );
            distances.put( stringIntegerEntry.getKey(), stringIntegerEntry.getValue() );});


        while(!queueOfNodes.isEmpty()){

            String currNodeName = queueOfNodes.remove();
            GraphNode currNode = graph.get( currNodeName );
            Integer currNodeDist = distances.get( currNodeName );

            Set<String> friends = currNode.friends.keySet();
            queueOfNodes.addAll( friends );
            graph.get( currNodeName ).friends.entrySet().forEach( stringIntegerEntry -> {
                if(distances.containsKey( stringIntegerEntry.getKey())){
                    if(distances.get( stringIntegerEntry.getKey()) > currNodeDist + stringIntegerEntry.getValue()){
                        distances.put( stringIntegerEntry.getKey(), stringIntegerEntry.getValue() + currNodeDist );
                        parents.put( stringIntegerEntry.getKey(), currNodeName );
                    }
                } else {
                    distances.put( stringIntegerEntry.getKey(), stringIntegerEntry.getValue() + currNodeDist );
                    parents.put( stringIntegerEntry.getKey(), currNodeName );
                }
            } );
        }

        String nextNode = finalNode;
        List<String> fastestRouteList = new ArrayList<>();
        fastestRouteList.add( finalNode );
        while(!nextNode.equals( startNode )){
             nextNode = parents.get( nextNode );
            fastestRouteList.add( nextNode );
        }
       // return Arrays.asList( "A", "B", "C" );
        log.info( "Shortest distance length: " + distances.get( finalNode ).toString() );
        return fastestRouteList;
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
