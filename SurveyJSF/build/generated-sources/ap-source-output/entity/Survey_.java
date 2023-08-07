package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-17T15:21:08")
@StaticMetamodel(Survey.class)
public class Survey_ { 

    public static volatile SingularAttribute<Survey, Integer> staffRating;
    public static volatile SingularAttribute<Survey, Integer> likelihoodOfRevisit;
    public static volatile SingularAttribute<Survey, String> cleanlinessRating;
    public static volatile SingularAttribute<Survey, Integer> speedRating;
    public static volatile SingularAttribute<Survey, Long> id;
    public static volatile SingularAttribute<Survey, Date> dateOfVisit;
    public static volatile SingularAttribute<Survey, Integer> tasteRating;

}