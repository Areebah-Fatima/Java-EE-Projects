
package bean;

// Imports
import ejb.BookEJB;
import entity.Author;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value = "mainPageBean")
@RequestScoped
public class MainPageBean {
    @EJB
    private BookEJB bookEJB;


    public MainPageBean() {
    }
    
    // returns list of authors
    public List<Author> getAuthorList()
    {
        return bookEJB.findAllAuthors();
    }
  
}
