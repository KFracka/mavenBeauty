package wiezienie;

import backend.Wiezien;
import frontend.EkranLogowaniaFrame;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Start {

    public static void main(String[] args) {
        EkranLogowaniaFrame el = new EkranLogowaniaFrame();
        //ls.setExtendedState(MAXIMIZED_BOTH);
        el.setSize(1000,670);
        el.setTitle("Centrum zarządzania");
        el.setVisible(true);

    }

    public void zapisz(Wiezien pt) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WiezieniePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(pt);
            em.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
        
    }
}
