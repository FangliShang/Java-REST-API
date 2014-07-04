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
@Table(name = "downvote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Downvote.findAll", query = "SELECT d FROM Downvote d"),
    @NamedQuery(name = "Downvote.findByIdDownVote", query = "SELECT d FROM Downvote d WHERE d.idDownVote = :idDownVote")})
public class Downvote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDownVote")
    private Integer idDownVote;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "idPost", referencedColumnName = "idPost")
    @ManyToOne(optional = false)
    private Post idPost;

    public Downvote() {
    }

    public Downvote(Integer idDownVote) {
        this.idDownVote = idDownVote;
    }

    public Integer getIdDownVote() {
        return idDownVote;
    }

    public void setIdDownVote(Integer idDownVote) {
        this.idDownVote = idDownVote;
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
        hash += (idDownVote != null ? idDownVote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Downvote)) {
            return false;
        }
        Downvote other = (Downvote) object;
        if ((this.idDownVote == null && other.idDownVote != null) || (this.idDownVote != null && !this.idDownVote.equals(other.idDownVote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Downvote[ idDownVote=" + idDownVote + " ]";
    }
    
}
