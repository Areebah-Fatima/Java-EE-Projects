
package testjparelation2;

import entity.Health_Record;
import entity.Person;
import entity.Player;
import entity.Team;
import entity.To_Do_Item;
import entity.To_Do_List;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author areebah
 */

public class TestJPARelation2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // One-to-one:  persist Person, Health_Record

        // Create person and Health record objects
        Person pers1 = new Person();
        Health_Record healthRec1 = new Health_Record();
        
        Person pers2 = new Person();
        Health_Record healthRec2 = new Health_Record();
        
        // Set person 1 info
        pers1.setId(1L);
        pers1.setFirstName("Joe");
        pers1.setLastName("Smith");
        pers1.setPhoneNumber("972-111-1111");

        // Set person 1 health record
        healthRec1.setId(1L);
        healthRec1.setHeight("5\'10\"");
        healthRec1.setWeight(150);
        healthRec1.setBloodPressure("120/80");

        pers1.setHealth_record(healthRec1);
        healthRec1.setPerson(pers1);
        
        // Set person 2 info
        pers2.setId(2L);
        pers2.setFirstName("Sue");
        pers2.setLastName("Jones");
        pers2.setPhoneNumber("972-222-2222");
     
        // Set person 1 health record
        healthRec2.setId(2L);
        healthRec2.setHeight("5\'8\"");
        healthRec2.setWeight(125);
        healthRec2.setBloodPressure("114/76");
    
        pers2.setHealth_record(healthRec2);
        healthRec2.setPerson(pers2);
       
        // persist person (cascade will do health record)
        persist(pers1);
        persist(pers2);

  
        // One-to-many:  persist To_Do_List, To_Do_Item
        
        // Create To do list object and set info
        To_Do_List ToDolist1 = new To_Do_List();
        ToDolist1.setId(1L);
        ToDolist1.setOwner("Joe Smith");
        
        // Create To do list object and set info
        To_Do_List ToDolist2 = new To_Do_List();
        ToDolist2.setId(2L);
        ToDolist2.setOwner("Sue Jones");
        
        // Create list items and set id/description
        To_Do_Item itm1 = new To_Do_Item();
        itm1.setId(1L);
        itm1.setDescription("Mow lawn");
        
        // Create list items and set id/description
        To_Do_Item itm2 = new To_Do_Item();
        itm2.setId(2L);
        itm2.setDescription("Buy milk");

        // Create list items and set id/description
        To_Do_Item itm3 = new To_Do_Item();
        itm3.setId(3L);
        itm3.setDescription("Go to post office");
        
        // Create list items and set id/description
        To_Do_Item itm4 = new To_Do_Item();
        itm4.setId(4L);
        itm4.setDescription("Enroll in course");

        // List for owner 1
        Collection<To_Do_Item> list1 = new ArrayList<To_Do_Item>();
        
        list1.add(itm1); 
        list1.add(itm2);

        ToDolist1.setToDoItemsCollection(list1);
        
        // List for owner 2
        Collection<To_Do_Item> list2 = new ArrayList<To_Do_Item>();
        
        list2.add(itm3); 
        list2.add(itm4);

        ToDolist2.setToDoItemsCollection(list2);
        
        itm1.setList(ToDolist1);
        itm2.setList(ToDolist1);
        
        itm3.setList(ToDolist2);
        itm4.setList(ToDolist2);

        // Persist the to do lists
        persist(ToDolist1);
        persist(ToDolist2);
        
       // Many-to-many:  persist player, team
        
        // Create players and set info
        Player player1 = new Player();
        player1.setId(1L);
        player1.setName("Tim Bishop");
        player1.setAge(10);
        
        // Create players and set info
        Player player2 = new Player();
        player2.setId(2L);
        player2.setName("Myra Adams");
        player2.setAge(9);
        
        // Create players and set info
        Player player3 = new Player();
        player3.setId(3L);
        player3.setName("Ron Maples");
        player3.setAge(11);
        
        // Create players and set info
        Player player4 = new Player();
        player4.setId(4L);
        player4.setName("Don Reed");
        player4.setAge(10);
        
         // Create teams and set info
        Team team1 = new Team();
        team1.setId(1L);
        team1.setName("Flyers");
        
        // Create teams and set info
        Team team2 = new Team();
        team2.setId(2L);
        team2.setName("Sluggers");
      
        // Make list for player 1's teams (team 1) 
        player1.setTeams(new ArrayList<Team>());
        player1.getTeams().add(team1);
        
        // Make list for player 2's teams (team 1, team 2) 
        player2.setTeams(new ArrayList<Team>());
        player2.getTeams().add(team1);
        player2.getTeams().add(team2);
        
        // Make list for player 3's teams (team 1, team 2) 
        player3.setTeams(new ArrayList<Team>());
        player3.getTeams().add(team1);
        player3.getTeams().add(team2);
        
        // Make list for player 4's teams (team 2) 
        player4.setTeams(new ArrayList<Team>());
        player4.getTeams().add(team2);

        // Make list to hold the players for each team
        team1.setPlayer(new ArrayList<Player>());
        team2.setPlayer(new ArrayList<Player>());
        
        // Team 1 has players 1, 2, 3
        team1.getPlayer().add(player1);
        team1.getPlayer().add(player2);
        team1.getPlayer().add(player3);
        
        // Team 1 has players 2, 3, 4
        team2.getPlayer().add(player2);
        team2.getPlayer().add(player3);
        team2.getPlayer().add(player4);
        
        // Persist player1. With cascade.PERSIST on both entities,
        // When player1 is persisted, so will team1, then so will player2, then team 2 ....
        persist(player1); 
        
        System.out.println("Done");
  
    }

    // Entity Manager
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestJPARelation2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
