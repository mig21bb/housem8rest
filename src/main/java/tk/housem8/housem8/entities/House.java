/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.beans.factory.annotation.Autowired;

import tk.housem8.housem8.repos.HouseRepository;
import tk.housem8.housem8.repos.MateRepository;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "house")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "House.findAll", query = "SELECT h FROM House h"),
    @NamedQuery(name = "House.findById", query = "SELECT h FROM House h WHERE h.id = :id"),
    @NamedQuery(name = "House.findByCountry", query = "SELECT h FROM House h WHERE h.country = :country"),
    @NamedQuery(name = "House.findByCity", query = "SELECT h FROM House h WHERE h.city = :city"),
    @NamedQuery(name = "House.findByStreet", query = "SELECT h FROM House h WHERE h.street = :street"),
    @NamedQuery(name = "House.findByCp", query = "SELECT h FROM House h WHERE h.cp = :cp"),
    @NamedQuery(name = "House.findByNumber", query = "SELECT h FROM House h WHERE h.number = :number"),
    @NamedQuery(name = "House.findByFloor", query = "SELECT h FROM House h WHERE h.floor = :floor"),
    @NamedQuery(name = "House.findByApartment", query = "SELECT h FROM House h WHERE h.apartment = :apartment"),
    @NamedQuery(name = "House.findByOther", query = "SELECT h FROM House h WHERE h.other = :other"),
    @NamedQuery(name = "House.findBySquareMeters", query = "SELECT h FROM House h WHERE h.squareMeters = :squareMeters")})
public class House implements Serializable {
    
    @Transient
    @Autowired
    MateRepository mateRepository;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "street")
    private String street;
    @Size(max = 45)
    @Column(name = "cp")
    private String cp;
    @Column(name = "number")
    private Integer number;
    @Column(name = "floor")
    private Integer floor;
    @Size(max = 45)
    @Column(name = "apartment")
    private String apartment;
    @Size(max = 45)
    @Column(name = "other")
    private String other;
    @Basic(optional = false)
    @NotNull
    @Column(name = "square_meters")
    private float squareMeters;    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "house",fetch = FetchType.LAZY)
    @JsonManagedReference(value="houseId")
    private List<Cost> costList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "houseId",fetch = FetchType.LAZY)
    @JsonManagedReference(value="houseId")
    private List<Room> roomList;
    @JoinColumn(name = "maker_id", referencedColumnName = "id")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JsonBackReference(value="maker")
    private Mate maker;
    
    
    @Transient    
    @JsonBackReference
    private List<Mate> livingMates;

    public House() {
    }

    public House(Integer id) {
        this.id = id;
        try{
            this.livingMates = mateRepository.findByHouse(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public House(Integer id, String city, String street, float squareMeters) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.squareMeters = squareMeters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getApartment() {
        return apartment;
    }

    public Mate getMaker() {
        return maker;
    }

    public void setMaker(Mate maker) {
        this.maker = maker;
    }
    
    

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public float getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(float squareMeters) {
        this.squareMeters = squareMeters;
    }

    @XmlTransient
    public List<Cost> getCostList() {
        return costList;
    }

    public void setCostList(List<Cost> costList) {
        this.costList = costList;
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
    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
    
    @XmlTransient
    public List<Mate> getLivingMates(){
        
       
       
        return this.livingMates;  
    }
    
    
    public void setLivingMates(List<Mate> livingMates) {
        this.livingMates = livingMates;
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
        if (!(object instanceof House)) {
            return false;
        }
        House other = (House) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tk.housem8.housem8.entities.House[ id=" + id + " ]";
    }
    
}
