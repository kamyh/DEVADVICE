package entities;

import entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-18T09:50:25")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, String> name;
    public static volatile SingularAttribute<Groups, Integer> id;
    public static volatile CollectionAttribute<Groups, Users> usersCollection;

}