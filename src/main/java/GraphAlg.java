
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;


@ToString
@EqualsAndHashCode
public class GraphAlg {


    public static String findPersonByAchievement(Map<String, Person> graph, String first, Person.Achievement achievement){

       Deque<String> kolejka = new ArrayDeque<>();
       populateQueue(kolejka, graph.get( first ).getFriends());
       String personWithAchievement = "None";

       while(!kolejka.isEmpty()){

           String person = kolejka.poll();
           if(hasAchievement(graph.get( person ), achievement)){
               personWithAchievement = person;
               break;
           } else {
               populateQueue( kolejka, graph.get( person ).getFriends() );
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
