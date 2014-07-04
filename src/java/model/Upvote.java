/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author B49072
 */
@Entity
@Table(name = "upvote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Upvote.findAll", query = "SELECT u FROM Upvote u"),
    @NamedQuery(name = "Upvote.findByIdUpVote", query = "SELECT u FROM Upvote u WHERE u.idUpVote = :idUpVote")})
public class Upvote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUpVote")
    private Integer idUpVote;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "idPost", referencedColumnName = "idPost")
    @ManyToOne(optional = false)
    private Post idPost;

    public Upvote() {
    }

    public Upvote(Integer idUpVote) {
        this.idUpVote = idUpVote;
    }

    public Integer getIdUpVote() {
        return idUpVote;
    }

    public void setIdUpVote(Integer idUpVote) {
        this.idUpVote = idUpVote;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Post getIdPost() {
        return idPost;
    }

    public void setIdPost(Post idPost) {
        this.idPost = idPost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUpVote != null ? idUpVote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Upvote)) {
            return false;
        }
        Upvote other = (Upvote) object;
        if ((this.idUpVote == null && other.idUpVote != null) || (this.idUpVote != null && !this.idUpVote.equals(other.idUpVote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Upvote[ idUpVote=" + idUpVote + " ]";
    }
    
}
