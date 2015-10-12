/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Victoria
 */
@Entity
@Table(name = "historial")
@NamedQueries({
    @NamedQuery(name = "Historial.findAll", query = "SELECT h FROM Historial h")})
public class Historial implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistorialPK historialPK;

    public Historial() {
    }

    public Historial(HistorialPK historialPK) {
        this.historialPK = historialPK;
    }

    public Historial(int idLicencia, String nombreUsuario) {
        this.historialPK = new HistorialPK(idLicencia, nombreUsuario);
    }

    public HistorialPK getHistorialPK() {
        return historialPK;
    }

    public void setHistorialPK(HistorialPK historialPK) {
        this.historialPK = historialPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historialPK != null ? historialPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.historialPK == null && other.historialPK != null) || (this.historialPK != null && !this.historialPK.equals(other.historialPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Historial[ historialPK=" + historialPK + " ]";
    }
    
}
