package backend;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Wiezien")
@NamedQueries({
    @NamedQuery(name = "Wiezien.findAll", query = "SELECT p FROM Wiezien p"),
    @NamedQuery(name = "Wiezien.findByPesel", query = "SELECT p FROM Wiezien p WHERE p.pesel = :pesel"),
    @NamedQuery(name = "Wiezien.findByImie", query = "SELECT p FROM Wiezien p WHERE p.imie = :imie"),
    @NamedQuery(name = "Wiezien.findByNazwisko", query = "SELECT p FROM Wiezien p WHERE p.nazwisko = :nazwisko"),
    @NamedQuery(name = "Wiezien.findByDataUrodzenia", query = "SELECT p FROM Wiezien p WHERE p.dataUrodzenia = :dataUrodzenia"),
    @NamedQuery(name = "Wiezien.findByPlec", query = "SELECT p FROM Wiezien p WHERE p.plec = :plec"),
    @NamedQuery(name = "Wiezien.findByPeselLike", query = "SELECT p FROM Wiezien p WHERE p.pesel LIKE :pesel")})
public class Wiezien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pesel")
    private Long pesel;
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "dataUrodzenia")
    @Temporal(TemporalType.DATE)
    private Date dataUrodzenia;
    @Column(name = "plec")
    private Boolean plec;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesel")
    private Collection<HistoriaTerapii> historiaTerapiiCollection;

    public Wiezien() {
    }

    public Wiezien(Long pesel) {
        this.pesel = pesel;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
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

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public Boolean getPlec() {
        return plec;
    }

    public void setPlec(Boolean plec) {
        this.plec = plec;
    }

    public Collection<HistoriaTerapii> getHistoriaTerapiiCollection() {
        return historiaTerapiiCollection;
    }

    public void setHistoriaTerapiiCollection(Collection<HistoriaTerapii> historiaTerapiiCollection) {
        this.historiaTerapiiCollection = historiaTerapiiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pesel != null ? pesel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Wiezien)) {
            return false;
        }
        Wiezien other = (Wiezien) object;
        if ((this.pesel == null && other.pesel != null) || (this.pesel != null && !this.pesel.equals(other.pesel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Wiezien[ pesel=" + pesel + " ]";
    }
    
}
