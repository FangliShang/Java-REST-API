/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Downvote;

/**
 *
 * @author B49072
 */
@Stateless
@Path("model.downvote")
public class DownvoteFacadeREST extends AbstractFacade<Downvote> {
    @PersistenceContext(unitName = "MyPost2PU")
    private EntityManager em;

    public DownvoteFacadeREST() {
        super(Downvote.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Downvote create(Downvote entity) {
        return super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Downvote entity) {
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
    public Downvote find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Downvote> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Downvote> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    
    @GET
    @Path("findbyuserandpost/{idUser}/{idPost}")
    @Produces({"application/xml", "application/json"})
    public List<Downvote> findDownvote(@PathParam("idUser") Integer idUser,@PathParam("idPost") Integer idPost){
        return  em.createQuery(
                     "SELECT c FROM Downvote c WHERE c.idUser.idUser =:idUser AND c.idPost.idPost=:idPost")
                    .setParameter("idUser", idUser)
                    .setParameter("idPost",idPost)
                    .getResultList();                
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
