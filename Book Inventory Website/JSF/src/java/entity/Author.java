/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

// imports
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

/**
 *
 * @author areebah
 */

// Named queries (depending on query they will return all table info, id, or author name)
@Entity
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findById", query = "SELECT a FROM Author a WHERE a.id = :id"),
    @NamedQuery(name = "Author.findByAuthor", query = "SELECT a FROM Author a WHERE a.author = :author"),
})

public class Author implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;

    // ID for this entity class is author
    @Id
    @Size(max = 50)
    private String author;
    private List<Book> books;

   public Author() {
   }

    public Author(String author) {
        this.author = author;
    }

    // getter setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

   public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (author != null ? author.hashCode() : 0);
        return hash;
    }

     @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.author == null && other.author != null) || (this.author != null && !this.author.equals(other.author))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Author[ id=" + author + " ]";
    }
    
}
