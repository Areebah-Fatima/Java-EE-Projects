
package entity;

// Imports
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author areebah
 */

// To Do List Entity Class
@Entity
public class To_Do_List implements Serializable {

    // To Do List:  ID, owner
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String owner;

    // Set up one to many relationship
    @OneToMany(mappedBy="list", cascade=CascadeType.PERSIST)
    private Collection<To_Do_Item> ToDoItemsCollection;

    // Getter Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Collection<To_Do_Item> getToDoItemsCollection() {
        return ToDoItemsCollection;
    }

    public void setToDoItemsCollection(Collection<To_Do_Item> ToDoItemsCollection) {
        this.ToDoItemsCollection = ToDoItemsCollection;
    }
    
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof To_Do_List)) {
            return false;
        }
        To_Do_List other = (To_Do_List) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.To_Do_List[ id=" + id + " ]";
    }
    
}
