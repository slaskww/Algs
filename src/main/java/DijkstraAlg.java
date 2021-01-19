import com.sun.deploy.util.ArrayUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class DijkstraAlg {


    public static List<String> findShortestRoute(String startNode, String finalNode , Map<String, GraphNode> graph){

        if(graph.isEmpty()) return Collections.emptyList();
        if(!graph.containsKey( startNode ) || !graph.containsKey( finalNode ))
            throw new IllegalArgumentException("Invalid startNode or finalNode argument");

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

         Collections.reverse( fastestRouteList );
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
