
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;


@ToString
@EqualsAndHashCode
public class GraphAlg {

    public static void main(String[] args) {


        Map<String, Person> graf = new HashMap<String, Person>(){{
            put("Anna", new Person("Anna", Person.Achievement.Fisherman, Collections.emptyList()) );
            put("Jola", new Person("Jola", Person.Achievement.Accountant, Collections.singletonList( "Anna" )));
            put("Zbyszek", new Person("Zbyszek", Person.Achievement.Babysitter, Collections.emptyList()));
            put("Tomek", new Person("Tomek", Person.Achievement.Gardener, Arrays.asList( "Zbyszek", "Jola" )) );
            put("Oliwia", new Person("Oliwia", Person.Achievement.Writer, Collections.singletonList( "Tomek" ) ));
            put("Marta", new Person("Marta", Person.Achievement.Babysitter, Collections.emptyList()));
            put("Marek", new Person("Marek", Person.Achievement.Accountant, Arrays.asList("Marta", "Oliwia")));
        }};

        String fisherman = findPersonByAchievement(graf, "Marek", Person.Achievement.Babysitter);
        System.out.println(fisherman);



    }

    public static String findPersonByAchievement(Map<String, Person> graph, String first, Person.Achievement achievement){

       Deque<String> kolejka = new ArrayDeque<>();
       populateQueue(kolejka, graph.get( first ).friends);
       String personWithAchievement = "None";

       while(!kolejka.isEmpty()){

           String person = kolejka.poll();
           if(hasAchievement(graph.get( person ), achievement)){
               personWithAchievement = person;
               break;
           } else {
               populateQueue( kolejka, graph.get( person ).friends );
           }

       }

        return personWithAchievement;
    }

    public static Deque<String> populateQueue(Deque<String> kolejka, List<String> names){
        kolejka.addAll( names );
        return kolejka;
    }

    public static Boolean hasAchievement(Person person, Person.Achievement achievement){
        return person.getAchievement().equals( achievement );
    }

    static class Person{
        private String name;
        private Achievement achievement;
        private List<String> friends;


        public Person(String name ,Achievement achievement, List<String> friends){
            this.name = name;
            this.achievement = achievement;
            this.friends = friends;
        }

        public Achievement getAchievement(){
            return this.achievement;
        }

        public List<String> getFriends(){
            return this.friends;
        }

        public String getName(){
            return this.name;
        }

        enum Achievement{
            Fisherman,
            Gardener,
            Accountant,
            Writer,
            Babysitter,
            Postman

        }
    }
}
