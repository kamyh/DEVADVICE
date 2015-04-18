package entities;

import entities.Devtools;
import entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-18T15:33:49")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Users> idUser;
    public static volatile SingularAttribute<Comments, Integer> id;
    public static volatile SingularAttribute<Comments, String> text;
    public static volatile SingularAttribute<Comments, Devtools> idDevtool;

}