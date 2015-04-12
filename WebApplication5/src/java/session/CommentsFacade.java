/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Comments;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author derua_000
 */
@Stateless
public class CommentsFacade extends AbstractFacade<Comments> {
    @PersistenceContext(unitName = "WebApplication5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentsFacade() {
        super(Comments.class);
    }
    
}
