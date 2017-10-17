/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cost_rest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CostRest.findAll", query = "SELECT c FROM CostRest c"),
    @NamedQuery(name = "CostRest.findById", query = "SELECT c FROM CostRest c WHERE c.id = :id"),
    @NamedQuery(name = "CostRest.findByDescription", query = "SELECT c FROM CostRest c WHERE c.description = :description"),
    @NamedQuery(name = "CostRest.findByPeriod", query = "SELECT c FROM CostRest c WHERE c.period = :period"),
    @NamedQuery(name = "CostRest.findByDatetime", query = "SELECT c FROM CostRest c WHERE c.datetime = :datetime"),
    @NamedQuery(name = "CostRest.findByAmount", query = "SELECT c FROM CostRest c WHERE c.amount = :amount"),
    @NamedQuery(name = "CostRest.findByMateId", query = "SELECT c FROM CostRest c WHERE c.mateId = :mateId"),
    @NamedQuery(name = "CostRest.findByHouseId", query = "SELECT c FROM CostRest c WHERE c.houseId = :houseId"),
    @NamedQuery(name = "CostRest.findByCostFamilyId", query = "SELECT c FROM CostRest c WHERE c.costFamilyId = :costFamilyId"),
    @NamedQuery(name = "CostRest.findByActivo", query = "SELECT c FROM CostRest c WHERE c.activo = :activo"),
    @NamedQuery(name = "CostRest.findByFechaCreacion", query = "SELECT c FROM CostRest c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "CostRest.findByFechaModificacion", query = "SELECT c FROM CostRest c WHERE c.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "CostRest.findByFechaBorrado", query = "SELECT c FROM CostRest c WHERE c.fechaBorrado = :fechaBorrado"),
    @NamedQuery(name = "CostRest.findByCommerceId", query = "SELECT c FROM CostRest c WHERE c.commerceId = :commerceId"),
    @NamedQuery(name = "CostRest.findByCommerceName", query = "SELECT c FROM CostRest c WHERE c.commerceName = :commerceName"),
    @NamedQuery(name = "CostRest.findByCommerceLogo", query = "SELECT c FROM CostRest c WHERE c.commerceLogo = :commerceLogo")})
public class CostRest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @Id
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "MATE_id")
    private int mateId;
    @Size(max = 45)
    @Column(name = "mate_name")
    private String mateName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOUSE_id")
    private int houseId;
    @Size(max = 100)
    @Column(name = "house_name")
    private String houseName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COST_FAMILY_id")
    private int costFamilyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "fecha_borrado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBorrado;
    @Column(name = "COMMERCE_id")
    private Integer commerceId;
    @Size(max = 45)
    @Column(name = "commerce_name")
    private String commerceName;
    @Size(max = 300)
    @Column(name = "commerce_logo")
    private String commerceLogo;

    public CostRest() {
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

    public int getMateId() {
        return mateId;
    }

    public void setMateId(int mateId) {
        this.mateId = mateId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getCostFamilyId() {
        return costFamilyId;
    }

    public void setCostFamilyId(int costFamilyId) {
        this.costFamilyId = costFamilyId;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public Integer getCommerceId() {
        return commerceId;
    }

    public void setCommerceId(Integer commerceId) {
        this.commerceId = commerceId;
    }

    public String getCommerceName() {
        return commerceName;
    }

    public void setCommerceName(String commerceName) {
        this.commerceName = commerceName;
    }

    public String getCommerceLogo() {
        return commerceLogo;
    }

    public void setCommerceLogo(String commerceLogo) {
        this.commerceLogo = commerceLogo;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }
    
    
    
}
