/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author derua_000
 */
@Entity
@Table(name = "devtools")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devtools.findAll", query = "SELECT d FROM Devtools d"),
    @NamedQuery(name = "Devtools.findById", query = "SELECT d FROM Devtools d WHERE d.id = :id"),
    @NamedQuery(name = "Devtools.findByIdUser", query = "SELECT d FROM Devtools d WHERE d.idUser.id = :id"),
    @NamedQuery(name = "Devtools.findByType", query = "SELECT d FROM Devtools d WHERE d.type = :type"),
    @NamedQuery(name = "Devtools.findByRank", query = "SELECT d FROM Devtools d WHERE d.rank = :rank"),
    @NamedQuery(name = "Devtools.findByCreatedAt", query = "SELECT d FROM Devtools d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "Devtools.findByUpdatedAt", query = "SELECT d FROM Devtools d WHERE d.updatedAt = :updatedAt"),
    @NamedQuery(name = "Devtools.findByUrl", query = "SELECT d FROM Devtools d WHERE d.url = :url"),
    @NamedQuery(name = "Devtools.findByImagePath", query = "SELECT d FROM Devtools d WHERE d.imagePath = :imagePath")})
public class Devtools implements Serializable {
    public enum Type {
        SDK,
        API,
        IDE,
        FRAMEWORK,
        PLUGINS;	
      }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 9)
    @Column(name = "type")
    private String type;
    @Column(name = "rank")
    private Integer rank;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @Size(max = 255)
    @Column(name = "image_path")
    private String imagePath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDevtool")
    private Collection<Comments> commentsCollection;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private Users idUser;
    @Column(name = "name")
    private String name;

    public Devtools() {
    }

    public Devtools(Integer id) {
        this.id = id;
    }
    
    public String getImg()
    {
        String urlImg = "";
        
        switch(this.type) {
            case "sdk":  urlImg = "http://blog.generalassemb.ly/blog/wp-content/uploads/2014/07/clean-code.jpg";  break;
            case "api":  urlImg = "http://developer.quantcast.com/files/API_PAGE_CLOUD_-_crop.png";  break;
            case "ide":  urlImg = "http://danston.com/portal/components/com_virtuemart/shop_image/product/Cable_Ide_133_4f0310cf51dd5.jpg";  break;
            case "framework":  urlImg = "http://images.atelier.net/sites/default/files/imagecache/scale_crop_587_310/articles/423600/atelier-nouvelle-programmation-informatique.jpg";  break;
            case "plugins":  urlImg = "http://www.wpmayor.com/wp-content/uploads/wordpress-plugins2.jpg";  break;
          }
        
        return urlImg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRank() {
        return rank;
    }


    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devtools)) {
            return false;
        }
        Devtools other = (Devtools) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Devtools[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
