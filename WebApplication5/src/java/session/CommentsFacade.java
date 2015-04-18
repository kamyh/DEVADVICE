/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Comments;
import entities.Devtools;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public List<Comments> findOwn(int id) {
        Query qry = em.createNamedQuery("Comments.findByIdDevtools");
        qry.setParameter("id", id);
        return qry.getResultList();
    }

    public Devtools findDev(int idDevTool) {
        Query qry = em.createNamedQuery("Devtools.findById");
        qry.setParameter("id", idDevTool);
        return (Devtools)qry.getResultList().get(0);
    }
    
}
