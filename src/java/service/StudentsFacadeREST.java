/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.students.Students;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author s7263
 */
@Stateless
@Path("com.students.students")
public class StudentsFacadeREST extends AbstractFacade<Students> {
    @PersistenceContext(unitName = "dsdpc2ServerAppPU")
    private EntityManager em;

    public StudentsFacadeREST() {
        super(Students.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Students entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Students entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Students find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Students> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Students> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("{firstname}") 
//  @Produces({"application/json"})  solo permite text/xml
    public List<Students> findByFirstname(@PathParam("firstname") String firstname) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Students> c = criteriaQuery.from(Students.class);
        criteriaQuery.select(c);
        
        criteriaQuery.where(criteriaBuilder.equal(c.get("firstname"), firstname));
        //criteriaQuery.w.liwhere(criteriaBuilder.getClass(c.get)
                       
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
