/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

// Named queries (depending on query they will return all table info, author (using writtenPK), title (using writtenPK), id, or isbn)
@Entity
@NamedQueries({
    @NamedQuery(name = "WrittenBy.findAll", query = "SELECT w FROM WrittenBy w"),
    @NamedQuery(name = "WrittenBy.findByAuthor", query = "SELECT w FROM WrittenBy w WHERE w.writtenByPK.author = :author"),
    @NamedQuery(name = "WrittenBy.findByTitle", query = "SELECT w FROM WrittenBy w WHERE w.writtenByPK.title = :title"),
    @NamedQuery(name = "WrittenBy.findById", query = "SELECT w FROM WrittenBy w WHERE w.id = :id"),
    @NamedQuery(name = "WrittenBy.findIsbn", query = "SELECT w FROM WrittenBy w WHERE w.isbn = :isbn")})
public class WrittenBy implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WrittenByPK writtenByPK;
    
    private String isbn;
    private Integer id;

    public WrittenBy() {
    }

    public WrittenBy(WrittenByPK writtenByPK) {
        this.writtenByPK = writtenByPK;
    }

    public WrittenBy(String author, String title) {
        this.writtenByPK = new WrittenByPK(author, title);
    }

    // getter setter
    public WrittenByPK getWrittenByPK() {
        return writtenByPK;
    }

    public void setWrittenByPK(WrittenByPK writtenByPK) {
        this.writtenByPK = writtenByPK;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (writtenByPK != null ? writtenByPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WrittenBy)) {
            return false;
        }
        WrittenBy other = (WrittenBy) object;
        if ((this.writtenByPK == null && other.writtenByPK != null) || (this.writtenByPK != null && !this.writtenByPK.equals(other.writtenByPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WrittenBy[ writtenByPK=" + writtenByPK + " ]";
    }
    
}
