package entities;

import entities.Comments;
import entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-20T10:55:58")
@StaticMetamodel(Devtools.class)
public class Devtools_ { 

    public static volatile SingularAttribute<Devtools, Users> idUser;
    public static volatile SingularAttribute<Devtools, Date> createdAt;
    public static volatile SingularAttribute<Devtools, String> imagePath;
    public static volatile SingularAttribute<Devtools, String> name;
    public static volatile SingularAttribute<Devtools, Integer> rank;
    public static volatile SingularAttribute<Devtools, String> description;
    public static volatile SingularAttribute<Devtools, Integer> id;
    public static volatile CollectionAttribute<Devtools, Comments> commentsCollection;
    public static volatile SingularAttribute<Devtools, String> type;
    public static volatile SingularAttribute<Devtools, String> url;
    public static volatile SingularAttribute<Devtools, Date> updatedAt;

}