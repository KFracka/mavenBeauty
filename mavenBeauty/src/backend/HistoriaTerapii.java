package backend;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HistoriaTerapii")
@NamedQueries({
    @NamedQuery(name = "HistoriaTerapii.findAll", query = "SELECT h FROM HistoriaTerapii h"),
    @NamedQuery(name = "HistoriaTerapii.findById", query = "SELECT h FROM HistoriaTerapii h WHERE h.id = :id"),
    @NamedQuery(name = "HistoriaTerapii.findByChoroba", query = "SELECT h FROM HistoriaTerapii h WHERE h.choroba = :choroba"),
    @NamedQuery(name = "HistoriaTerapii.findByDataPrzyjecia", query = "SELECT h FROM HistoriaTerapii h WHERE h.dataPrzyjecia = :dataPrzyjecia"),
    @NamedQuery(name = "HistoriaTerapii.findByDataWypisu", query = "SELECT h FROM HistoriaTerapii h WHERE h.dataWypisu = :dataWypisu"),
    @NamedQuery(name = "HistoriaTerapii.findByIdPsychologa", query = "SELECT h FROM HistoriaTerapii h WHERE h.idPsychologa.idPsychologa = :idPsychologa"),
    @NamedQuery(name = "HistoriaTerapii.findByPesel", query = "SELECT h FROM HistoriaTerapii h WHERE h.pesel.pesel = :pesel")})
public class HistoriaTerapii implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "choroba")
    private String choroba;
    @Column(name = "dataPrzyjecia")
    @Temporal(TemporalType.DATE)
    private Date dataPrzyjecia;
    @Column(name = "dataWypisu")
    @Temporal(TemporalType.DATE)
    private Date dataWypisu;
    @JoinColumn(name = "idPsychologa", referencedColumnName = "idPsychologa")
    @ManyToOne
    private Psycholog idPsychologa;
    @JoinColumn(name = "pesel", referencedColumnName = "pesel")
    @ManyToOne(optional = false)
    private Wiezien pesel;
    @JoinColumn(name = "nazwaOddzialu", referencedColumnName = "nazwaOddzialu")
    @ManyToOne
    private Wiezienie nazwaOddzialu;

    public HistoriaTerapii() {
    }

    public HistoriaTerapii(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getChoroba() {
        return choroba;
    }

    public void setChoroba(String choroba) {
        this.choroba = choroba;
    }

    public Date getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(Date dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }

    public Date getDataWypisu() {
        return dataWypisu;
    }

    public void setDataWypisu(Date dataWypisu) {
        this.dataWypisu = dataWypisu;
    }

    public Psycholog getIdPsychologa() {
        return idPsychologa;
    }

    public void setIdPsychologa(Psycholog idPsychologa) {
        this.idPsychologa = idPsychologa;
    }

    public Wiezien getPesel() {
        return pesel;
    }

    public void setPesel(Wiezien pesel) {
        this.pesel = pesel;
    }

    public Wiezienie getNazwaOddzialu() {
        return nazwaOddzialu;
    }

    public void setNazwaOddzialu(Wiezienie nazwaOddzialu) {
        this.nazwaOddzialu = nazwaOddzialu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof HistoriaTerapii)) {
            return false;
        }
        HistoriaTerapii other = (HistoriaTerapii) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.HistoriaTerapii[ id=" + id + " ]";
    }
    
}
