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
import model.Comment;

/**
 *
 * @author B49072
 */
@Stateless
@Path("model.comment")
public class CommentFacadeREST extends AbstractFacade<Comment> {
    @PersistenceContext(unitName = "MyPost2PU")
    private EntityManager em;
    public CommentFacadeREST() {
        super(Comment.class);
    }
    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Comment create(Comment entity) {
        return super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Comment entity) {
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
    public Comment find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Comment> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Comment> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("findcomments/{idPost}")
    @Produces({"application/xml", "application/json"})
    public List<Comment> findByIdPost(@PathParam("idPost") Integer idPost){
        return  em.createQuery(
                     "SELECT c FROM Comment c WHERE c.idPost.idPost =:idPost")
                    .setParameter("idPost", idPost)         
                    .getResultList();                
    }
    
    @GET
    @Path("findbyiduser/{idUser}")
    @Produces({"application/xml", "application/json"})
    public List<Comment> findByIdUser(@PathParam("idUser") Integer idUser){
        return  em.createQuery(
                     "SELECT c FROM Comment c WHERE c.idUser.idUser =:idUser")
                    .setParameter("idUser", idUser)         
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
