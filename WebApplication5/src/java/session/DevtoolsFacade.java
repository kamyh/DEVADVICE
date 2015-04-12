/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

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
public class DevtoolsFacade extends AbstractFacade<Devtools> {
    @PersistenceContext(unitName = "WebApplication5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevtoolsFacade() {
        super(Devtools.class);
    }
            
    public List<Devtools> findOwn(int id) {
        Query qry = em.createNamedQuery("Devtools.findByIdUser");
        qry.setParameter("id", id);
        return qry.getResultList();
    }
}
