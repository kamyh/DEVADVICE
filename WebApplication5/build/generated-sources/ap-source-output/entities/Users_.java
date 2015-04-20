package entities;

import entities.Comments;
import entities.Devtools;
import entities.Groups;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-19T17:12:42")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, String> loginName;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile CollectionAttribute<Users, Comments> commentsCollection;
    public static volatile CollectionAttribute<Users, Groups> groupsCollection;
    public static volatile CollectionAttribute<Users, Devtools> devtoolsCollection;
    public static volatile SingularAttribute<Users, String> lastname;

}