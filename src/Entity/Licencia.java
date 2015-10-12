/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Victoria
 */
@Entity
@Table(name = "licencia")
@NamedQueries({
    @NamedQuery(name = "Licencia.findAll", query = "SELECT l FROM Licencia l")})
public class Licencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "fk_titular")
    private int fkTitular;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLicencia")
    private Integer idLicencia;
    @Basic(optional = false)
    @Column(name = "fechaEmision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Basic(optional = false)
    @Column(name = "fechaExpiracion")
    @Temporal(TemporalType.DATE)
    private Date fechaExpiracion;
    @Basic(optional = false)
    @Column(name = "clase")
    private String clase;
    @Column(name = "costo")
    private Long costo;
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    public Licencia() {
    }

    public Licencia(Integer idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Licencia(Integer idLicencia, int fkTitular, Date fechaEmision, Date fechaExpiracion, String clase, String descripcion) {
        this.idLicencia = idLicencia;
        this.fkTitular = fkTitular;
        this.fechaEmision = fechaEmision;
        this.fechaExpiracion = fechaExpiracion;
        this.clase = clase;
        this.descripcion = descripcion;
    }

    public int getFkTitular() {
        return fkTitular;
    }

    public void setFkTitular(int fkTitular) {
        this.fkTitular = fkTitular;
    }

    public Integer getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(Integer idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Long getCosto() {
        return costo;
    }

    public void setCosto(Long costo) {
        this.costo = costo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLicencia != null ? idLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.idLicencia == null && other.idLicencia != null) || (this.idLicencia != null && !this.idLicencia.equals(other.idLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Licencia[ idLicencia=" + idLicencia + " ]";
    }
    
}
