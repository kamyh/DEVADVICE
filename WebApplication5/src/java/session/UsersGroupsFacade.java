/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Users;
import entities.UsersGroups;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author derua_000
 */
@Stateless
public class UsersGroupsFacade extends AbstractFacade<UsersGroups> {
    @PersistenceContext(unitName = "WebApplication5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersGroupsFacade() {
        super(UsersGroups.class);
    }

}
