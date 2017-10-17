/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "cost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cost.findAll", query = "SELECT c FROM Cost c"),
    @NamedQuery(name = "Cost.findById", query = "SELECT c FROM Cost c WHERE c.id = :id"),
    @NamedQuery(name = "Cost.findByDescription", query = "SELECT c FROM Cost c WHERE c.description = :description"),
    @NamedQuery(name = "Cost.findByPeriod", query = "SELECT c FROM Cost c WHERE c.period = :period"),
    @NamedQuery(name = "Cost.findByDatetime", query = "SELECT c FROM Cost c WHERE c.datetime = :datetime"),
    @NamedQuery(name = "Cost.findByHouseId", query = "SELECT c FROM Cost c WHERE c.house = :houseId"),
    @NamedQuery(name = "Cost.findByCommerce", query = "SELECT c FROM Cost c WHERE c.commerce = :commerce"),
    @NamedQuery(name = "Cost.findByAmount", query = "SELECT c FROM Cost c WHERE c.amount = :amount")})

public class Cost implements Serializable {

  

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Column(name = "period")
    private Integer period;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Float amount;
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
    
    @JoinColumn(name = "cost_family_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonBackReference(value="costFamilyId")
    private CostFamily costFamily;
    
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonBackReference(value="houseId")
    private House house;

    @JoinColumn(name = "mate_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonBackReference(value="mateId")
    private Mate mate;

    @JoinColumn(name = "COMMERCE_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    @JsonBackReference(value="commerce")
    private Commerce commerce;

    public Cost() {
        System.out.println("Creating a new Cost");
    }

    public Cost(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public CostFamily getCostFamily() {
        return costFamily;
    }
  @JsonValue
    public void setCostFamily(CostFamily costFamily) {
        this.costFamily = costFamily;
    }

    public Commerce getCommerce() {
        return commerce;
    }
  @JsonValue
    public void setCommerce(Commerce commerce) {
        this.commerce = commerce;
    }

    /* */
    public House getHouse() {
        return house;
    }
  @JsonValue
    public void setHouse(House house) {
        this.house = house;
    }

    public Mate getMate() {
        return mate;
    }
  @JsonValue
    public void setMate(Mate mate) {
        this.mate = mate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cost)) {
            return false;
        }
        Cost other = (Cost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tk.housem8.housem8.entities.Cost[ id=" + id + " ]";
    }

    

}
