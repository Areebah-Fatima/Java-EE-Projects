/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Author;
import entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BookEJB {
    @PersistenceContext(unitName = "JSFPU")
    private EntityManager em;

    
    public void persist(Object object) {
        em.persist(object);
    }

    // returns list of all authors by using named query in author class
    public List<Author> findAllAuthors()
    {
        System.out.println("calling findAllAuthors");
        Query q = em.createNamedQuery("Author.findAll", Author.class);
        
        return q.getResultList();
          
    }
    
    // returns all books by calling named query in book class
    public List<Book> findAllBooks()
    {
         System.out.println("calling findAllBooks");
         return em.createNamedQuery("Book.findAll", Book.class).getResultList(); 
    }
       
    // returns a author using name query
    public Author getAuthor(String author)
    {
        System.out.println("calling getAuthor"+author);

        return em.createNamedQuery("Author.findByAuthor", Author.class)
                .setParameter("author", author)
                .getSingleResult();
    }
    
    // Gets books by an author back by passing author name to a query in the book class
    public List<Book> getBooksForAuthor(String author)
    {
        return em.createNamedQuery("Book.findBooksByAuthor", Book.class)
                .setParameter("author", author)
                .getResultList();
    }

}
