package entity;

import entity.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-17T15:34:51")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile ListAttribute<Author, Book> books;
    public static volatile SingularAttribute<Author, String> author;
    public static volatile SingularAttribute<Author, Integer> id;

}