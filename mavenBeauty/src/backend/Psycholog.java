package backend;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Psycholog")
@NamedQueries({
    @NamedQuery(name = "Psycholog.findAll", query = "SELECT l FROM Psycholog l"),
    @NamedQuery(name = "Psycholog.findByIdPsychologa", query = "SELECT l FROM Psycholog l WHERE l.idPsychologa = :idPsychologa"),
    @NamedQuery(name = "Psycholog.findByHaslo", query = "SELECT l FROM Psycholog l WHERE l.haslo = :haslo"),
    @NamedQuery(name = "Psycholog.findByImie", query = "SELECT l FROM Psycholog l WHERE l.imie = :imie"),
    @NamedQuery(name = "Psycholog.findByNazwisko", query = "SELECT l FROM Psycholog l WHERE l.nazwisko = :nazwisko"),
    @NamedQuery(name = "Psycholog.findBySpecjalizacja", query = "SELECT l FROM Psycholog l WHERE l.specjalizacja = :specjalizacja"),
    @NamedQuery(name = "Psycholog.findByIdPsychologaAndHaslo", query = "SELECT l FROM Psycholog l WHERE l.idPsychologa = :idPsychologa AND l.haslo = :haslo")})
public class Psycholog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPsychologa")
    private Long idPsychologa;
    @Column(name = "haslo")
    private String haslo;
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "specjalizacja")
    private String specjalizacja;
    @OneToMany(mappedBy = "idPsychologa")
    private Collection<HistoriaTerapii> historiaTerapiiCollection;
    @JoinColumn(name = "nazwaOddzialu", referencedColumnName = "nazwaOddzialu")
    @ManyToOne
    private Wiezienie nazwaOddzialu;

    public Psycholog() {
    }

    public Psycholog(Long idPsychologa) {
        this.idPsychologa = idPsychologa;
    }

    public Long getIdPsychologa() {
        return idPsychologa;
    }

    public void setIdPsychologa(Long idPsychologa) {
        this.idPsychologa = idPsychologa;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    public Collection<HistoriaTerapii> getHistoriaTerapiiCollection() {
        return historiaTerapiiCollection;
    }

    public void setHistoriaTerapiiCollection(Collection<HistoriaTerapii> historiaTerapiiCollection) {
        this.historiaTerapiiCollection = historiaTerapiiCollection;
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
        hash += (idPsychologa != null ? idPsychologa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Psycholog)) {
            return false;
        }
        Psycholog other = (Psycholog) object;
        if ((this.idPsychologa == null && other.idPsychologa != null) || (this.idPsychologa != null && !this.idPsychologa.equals(other.idPsychologa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Psycholog[ idPsychologa=" + idPsychologa + " ]";
    }
    
}
