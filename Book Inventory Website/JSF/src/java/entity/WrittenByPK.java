
package entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 *
 * @author areebah
 */
@Embeddable
public class WrittenByPK implements Serializable {
    
    // author name should be up to 50 characters
    @Size(max = 50)
    private String author;
    
    // title name should be up to 50 characters
    @Size(max = 50)
    private String title;

    public WrittenByPK() {
    }

    public WrittenByPK(String author, String title) {
        this.author = author;
        this.title = title;
    }

    // getter setter
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (author != null ? author.hashCode() : 0);
        hash += (title != null ? title.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WrittenByPK)) {
            return false;
        }
        WrittenByPK other = (WrittenByPK) object;
        if ((this.author == null && other.author != null) || (this.author != null && !this.author.equals(other.author))) {
            return false;
        }
        if ((this.title == null && other.title != null) || (this.title != null && !this.title.equals(other.title))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WrittenByPK[ author=" + author + ", title=" + title + " ]";
    }
    
}
