/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

// imports
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author areebah
 */


@Stateless
public class SurveyBean {

// Persistence unit with entity manager
@PersistenceContext(unitName="SurveyJSFPU")
private EntityManager em;

public void persist(Object object){
    
    em.persist(object);
}

}
