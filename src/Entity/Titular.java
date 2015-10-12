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
import javax.persistence.Lob;
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
@Table(name = "titular")
@NamedQueries({
    @NamedQuery(name = "Titular.findAll", query = "SELECT t FROM Titular t")})
public class Titular implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTitular")
    private Integer idTitular;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "nroDocumento")
    private int nroDocumento;
    @Basic(optional = false)
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Basic(optional = false)
    @Column(name = "fk_grupoSanguineo")
    private int fkgrupoSanguineo;
    @Basic(optional = false)
    @Column(name = "fk_factorRH")
    private int fkfactorRH;
    @Basic(optional = false)
    @Column(name = "fk_direccion")
    private int fkDireccion;
    @Basic(optional = false)
    @Column(name = "fk_tipoDocumento")
    private int fktipoDocumento;
    @Basic(optional = false)
    @Column(name = "donante")
    private boolean donante;
    @Basic(optional = false)
    @Column(name = "claseSolicitada")
    private String claseSolicitada;

    public Titular() {
    }

    public Titular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public Titular(Integer idTitular, String nombre, String apellido, int nroDocumento, Date fechaNacimiento, int fkgrupoSanguineo, int fkfactorRH, int fkDireccion, int fktipoDocumento, boolean donante, String claseSolicitada) {
        this.idTitular = idTitular;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroDocumento = nroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.fkgrupoSanguineo = fkgrupoSanguineo;
        this.fkfactorRH = fkfactorRH;
        this.fkDireccion = fkDireccion;
        this.fktipoDocumento = fktipoDocumento;
        this.donante = donante;
        this.claseSolicitada = claseSolicitada;
    }

    public Integer getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Integer idTitular) {
        this.idTitular = idTitular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getFkgrupoSanguineo() {
        return fkgrupoSanguineo;
    }

    public void setFkgrupoSanguineo(int fkgrupoSanguineo) {
        this.fkgrupoSanguineo = fkgrupoSanguineo;
    }

    public int getFkfactorRH() {
        return fkfactorRH;
    }

    public void setFkfactorRH(int fkfactorRH) {
        this.fkfactorRH = fkfactorRH;
    }

    public int getFkDireccion() {
        return fkDireccion;
    }

    public void setFkDireccion(int fkDireccion) {
        this.fkDireccion = fkDireccion;
    }

    public int getFktipoDocumento() {
        return fktipoDocumento;
    }

    public void setFktipoDocumento(int fktipoDocumento) {
        this.fktipoDocumento = fktipoDocumento;
    }

    public boolean getDonante() {
        return donante;
    }

    public void setDonante(boolean donante) {
        this.donante = donante;
    }

    public String getClaseSolicitada() {
        return claseSolicitada;
    }

    public void setClaseSolicitada(String claseSolicitada) {
        this.claseSolicitada = claseSolicitada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTitular != null ? idTitular.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titular)) {
            return false;
        }
        Titular other = (Titular) object;
        if ((this.idTitular == null && other.idTitular != null) || (this.idTitular != null && !this.idTitular.equals(other.idTitular))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Titular[ idTitular=" + idTitular + " ]";
    }
    
}
