import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GraphSearchTest {


    private static Map<String, GraphAlg.Person> graph;

    @BeforeAll
    public static void initiateGraph(){

        graph = new HashMap<String, GraphAlg.Person>(){{
            put("Anna", new GraphAlg.Person("Anna", GraphAlg.Person.Achievement.Fisherman, Collections.emptyList()) );
            put("Jola", new GraphAlg.Person("Jola", GraphAlg.Person.Achievement.Accountant, Collections.singletonList( "Anna" )));
            put("Zbyszek", new GraphAlg.Person("Zbyszek", GraphAlg.Person.Achievement.Babysitter, Collections.emptyList()));
            put("Tomek", new GraphAlg.Person("Tomek", GraphAlg.Person.Achievement.Gardener, Arrays.asList( "Zbyszek", "Jola" )) );
            put("Oliwia", new GraphAlg.Person("Oliwia", GraphAlg.Person.Achievement.Writer, Collections.singletonList( "Tomek" ) ));
            put("Marta", new GraphAlg.Person("Marta", GraphAlg.Person.Achievement.Babysitter, Collections.emptyList()));
            put("Marek", new GraphAlg.Person("Marek", GraphAlg.Person.Achievement.Accountant, Arrays.asList("Marta", "Oliwia")));
        }};
    }

    @Test
    public void findFirstFisherman(){

       String person =  GraphAlg.findPersonByAchievement( graph, "Marek", GraphAlg.Person.Achievement.Fisherman);
        assertEquals("Anna", person);
        assertNotEquals( "Tomek", person );
    }

    @Test
    public void findFirstBabysitter(){

        String person =  GraphAlg.findPersonByAchievement( graph, "Marek", GraphAlg.Person.Achievement.Babysitter);
        assertEquals("Marta", person);
        assertNotEquals( "Zbyszek", person );
    }

    @Test
    public void findNotFirstPostman(){

        String person =  GraphAlg.findPersonByAchievement( graph, "Marek", GraphAlg.Person.Achievement.Postman);
        assertEquals( "None", person );
    }


    @Test
    public void findFirstGardener(){

        String person =  GraphAlg.findPersonByAchievement( graph, "Oliwia", GraphAlg.Person.Achievement.Gardener);
        assertEquals( "Tomek", person );
    }
}
