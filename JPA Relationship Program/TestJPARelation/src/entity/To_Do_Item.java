
package entity;

// Imports
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 *
 * @author areebah
 */

// To Do Item Entity Class
@Entity
public class To_Do_Item implements Serializable {

    // To Do Item:  ID, description
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String description;
    
    // Set up one to many relationship
    @JoinColumn(name="List_FK")
    private To_Do_List list;

    // Getter Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public To_Do_List getList() {
        return list;
    }

    public void setList(To_Do_List list) {
        this.list = list;
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
        if (!(object instanceof To_Do_Item)) {
            return false;
        }
        To_Do_Item other = (To_Do_Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.To_Do_Item[ id=" + id + " ]";
    }
    
}
