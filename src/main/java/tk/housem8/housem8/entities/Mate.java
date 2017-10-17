/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "mate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mate.findAll", query = "SELECT m FROM Mate m"),
    @NamedQuery(name = "Mate.findById", query = "SELECT m FROM Mate m WHERE m.id = :id"),
    @NamedQuery(name = "Mate.findByName", query = "SELECT m FROM Mate m WHERE m.name = :name"),
    @NamedQuery(name = "Mate.findBySurname1", query = "SELECT m FROM Mate m WHERE m.surname1 = :surname1"),
    @NamedQuery(name = "Mate.findBySurname2", query = "SELECT m FROM Mate m WHERE m.surname2 = :surname2"),
    @NamedQuery(name = "Mate.findByBirthDate", query = "SELECT m FROM Mate m WHERE m.birthDate = :birthDate"),
    @NamedQuery(name = "Mate.findByNationality", query = "SELECT m FROM Mate m WHERE m.nationality = :nationality"),
    @NamedQuery(name = "Mate.findByEmail", query = "SELECT m FROM Mate m WHERE m.email = :email"),
    @NamedQuery(name = "Mate.findByUser", query = "SELECT m FROM Mate m WHERE m.user = :user"),
    @NamedQuery(name = "Mate.findByPass", query = "SELECT m FROM Mate m WHERE m.pass = :pass")})
public class Mate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "surname1")
    private String surname1;
    @Size(max = 45)
    @Column(name = "surname2")
    private String surname2;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Size(max = 45)
    @Column(name = "nationality")
    private String nationality;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "user")
    private String user;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "fecha_borrado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBorrado;
    @Column(name = "activo")
    private boolean activo;
    
    
    
    
    
    @Size(max = 45)
    @Column(name = "pass")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String pass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mate",fetch = FetchType.LAZY)
    @JsonManagedReference(value="mateId")
    private List<Cost> costList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payer",fetch = FetchType.LAZY)
    @JsonManagedReference(value="payer")
    private List<Compensation> compensationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiver",fetch = FetchType.LAZY)
    @JsonManagedReference(value="receiver")
    private List<Compensation> compensationList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mate",fetch = FetchType.LAZY)
    @JsonManagedReference(value="mate")
    private List<Ocupation> ocupationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maker",fetch = FetchType.LAZY)
    @JsonManagedReference(value="maker")
    private List<House> createdHousesList;

    public Mate() {
    }

    public Mate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaBorrado() {
        return fechaBorrado;
    }

    public void setFechaBorrado(Date fechaBorrado) {
        this.fechaBorrado = fechaBorrado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Cost> getCostList() {
        return costList;
    }

    public void setCostList(List<Cost> costList) {
        this.costList = costList;
    }

    @XmlTransient
    public List<Compensation> getCompensationList() {
        return compensationList;
    }

    public void setCompensationList(List<Compensation> compensationList) {
        this.compensationList = compensationList;
    }

    @XmlTransient
    public List<Compensation> getCompensationList1() {
        return compensationList1;
    }

    public void setCompensationList1(List<Compensation> compensationList1) {
        this.compensationList1 = compensationList1;
    }

    @XmlTransient
    public List<Ocupation> getOcupationList() {
        return ocupationList;
    }

    public void setOcupationList(List<Ocupation> ocupationList) {
        this.ocupationList = ocupationList;
    }
    
    @XmlTransient
    public List<House> getCreatedHousesList() {
        return createdHousesList;
    }

    public void setCreatedHousesList(List<House> createdHousesList) {
        this.createdHousesList = createdHousesList;
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
        if (!(object instanceof Mate)) {
            return false;
        }
        Mate other = (Mate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tk.housem8.housem8.entities.Mate[ id=" + id + " ]";
    }
    
}
