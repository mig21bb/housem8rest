/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "pictures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pictures.findAll", query = "SELECT p FROM Pictures p"),
    @NamedQuery(name = "Pictures.findById", query = "SELECT p FROM Pictures p WHERE p.id = :id"),
    @NamedQuery(name = "Pictures.findByUrl", query = "SELECT p FROM Pictures p WHERE p.url = :url"),
    @NamedQuery(name = "Pictures.findByDatetime", query = "SELECT p FROM Pictures p WHERE p.datetime = :datetime"),
    @NamedQuery(name = "Pictures.findByDataId", query = "SELECT p FROM Pictures p WHERE p.dataId = :dataId")})
public class Pictures implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "url")
    private String url;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Lob
    @Column(name = "active")
    private byte[] active;
    @Column(name = "data_id")
    private Integer dataId;
    

    public Pictures() {
    }

    public Pictures(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public byte[] getActive() {
        return active;
    }

    public void setActive(byte[] active) {
        this.active = active;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
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
        if (!(object instanceof Pictures)) {
            return false;
        }
        Pictures other = (Pictures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tk.housem8.housem8.entities.Pictures[ id=" + id + " ]";
    }
    
}
