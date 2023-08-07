
package bean;

// Imports
import ejb.BookEJB;
import entity.Author;
import entity.Book;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;



@Named(value = "showAuthorBean")
@RequestScoped
public class ShowAuthorBean {
    @EJB
    private BookEJB bookEJB;
    private Author author;
    
    public ShowAuthorBean() {
    }
    
    // getter setter
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    // function to call author info page
    public String showAuthor(Author author) {
        this.author = author;
        return "ShowAuthor.xhtml";
    }
    
    // function to reutrn back to author page (by passing author name back)
    public String backToAuthor() {
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
      String authorname =  params.get("author"); 
      author = bookEJB.getAuthor(authorname);
      return "ShowAuthor.xhtml";
    }
    
    // passes author name to get written by books and call book list page
    public String showWrittenBooks() {
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = 
        fc.getExternalContext().getRequestParameterMap();
      String authorname =  params.get("author"); 
      
      author = bookEJB.getAuthor(authorname);
      return "Books.xhtml";
    }
    
    // calls for book list
    public List<Book> getBookList()
    {
        if (author != null)
           return bookEJB.getBooksForAuthor(author.getAuthor());
        else
           return null;
    }

}
