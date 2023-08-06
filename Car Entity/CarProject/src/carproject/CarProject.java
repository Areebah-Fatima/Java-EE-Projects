
package carproject;

// Imports
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author areebah
 */

public class CarProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CarProject demo = new CarProject();

        // Create Car 1
        Car car1 = new Car();
        car1.setMake("Honda");
        car1.setModel("Civic");
        car1.setCarYear(2009);
        
        // Persist car1 to database
        demo.persist(car1);    
        
        // Create Car 2
        Car car2 = new Car();
        car2.setMake("Toyota");
        car2.setModel("Carolla");
        car2.setCarYear(2021);
        
        // Persist car2 to database
        demo.persist(car2);    
        
        // Create Car 3
        Car car3 = new Car();
        car3.setMake("Nissan");
        car3.setModel("Altima");
        car3.setCarYear(2013);
        
        // Persist car3 to database
        demo.persist(car3);  
        
    }

    // Entity Manager
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarProjectPU");
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
