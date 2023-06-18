package backend;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Wiezienie")
@NamedQueries({
    @NamedQuery(name = "Wiezienie.findAll", query = "SELECT s FROM Wiezienie s"),
    @NamedQuery(name = "Wiezienie.findByNazwaOddzialu", query = "SELECT s FROM Wiezienie s WHERE s.nazwaOddzialu = :nazwaOddzialu"),
    @NamedQuery(name = "Wiezienie.findByNumerOddzialu", query = "SELECT s FROM Wiezienie s WHERE s.numerOddzialu = :numerOddzialu")})
public class Wiezienie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nazwaOddzialu")
    private String nazwaOddzialu;
    @Column(name = "numerOddzialu")
    private Integer numerOddzialu;
    @OneToMany(mappedBy = "nazwaOddzialu")
    private Collection<HistoriaTerapii> historiaTerapiiCollection;
    @OneToMany(mappedBy = "nazwaOddzialu")
    private Collection<Psycholog> psychologCollection;

    public Wiezienie() {
    }

    public Wiezienie(String nazwaOddzialu) {
        this.nazwaOddzialu = nazwaOddzialu;
    }

    public String getNazwaOddzialu() {
        return nazwaOddzialu;
    }

    public void setNazwaOddzialu(String nazwaOddzialu) {
        this.nazwaOddzialu = nazwaOddzialu;
    }

    public Integer getNumerOddzialu() {
        return numerOddzialu;
    }

    public void setNumerOddzialu(Integer numerOddzialu) {
        this.numerOddzialu = numerOddzialu;
    }

    public Collection<HistoriaTerapii> getHistoriaTerapiiCollection() {
        return historiaTerapiiCollection;
    }

    public void setHistoriaTerapiiCollection(Collection<HistoriaTerapii> historiaTerapiiCollection) {
        this.historiaTerapiiCollection = historiaTerapiiCollection;
    }

    public Collection<Psycholog> getPsychologCollection() {
        return psychologCollection;
    }

    public void setPsychologCollection(Collection<Psycholog> psychologCollection) {
        this.psychologCollection = psychologCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nazwaOddzialu != null ? nazwaOddzialu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Wiezienie)) {
            return false;
        }
        Wiezienie other = (Wiezienie) object;
        if ((this.nazwaOddzialu == null && other.nazwaOddzialu != null) || (this.nazwaOddzialu != null && !this.nazwaOddzialu.equals(other.nazwaOddzialu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Wiezienie[ nazwaOddzialu=" + nazwaOddzialu + " ]";
    }
    
}
