/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Victoria
 */
@Embeddable
public class HistorialPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idLicencia")
    private int idLicencia;
    @Basic(optional = false)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    public HistorialPK() {
    }

    public HistorialPK(int idLicencia, String nombreUsuario) {
        this.idLicencia = idLicencia;
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(int idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLicencia;
        hash += (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialPK)) {
            return false;
        }
        HistorialPK other = (HistorialPK) object;
        if (this.idLicencia != other.idLicencia) {
            return false;
        }
        if ((this.nombreUsuario == null && other.nombreUsuario != null) || (this.nombreUsuario != null && !this.nombreUsuario.equals(other.nombreUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.HistorialPK[ idLicencia=" + idLicencia + ", nombreUsuario=" + nombreUsuario + " ]";
    }
    
}
