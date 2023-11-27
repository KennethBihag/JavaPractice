
import com.kenneth.model.*;
import jakarta.persistence.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.kenneth.my_database");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Brand[] brands = new Brand[3];
        brands[0]=new Brand("Fendong");
        brands[1] = new Brand("Sm Bonus");
        brands[2] = new Brand("Sira Mixx");
        for(var b : brands)
            em.persist(b);
        Material[] mats = new Material[4];
        mats[0] = new Material("wood");
        mats[1] = new Material("plastic");
        mats[2] = new Material("narra");
        mats[3] = new Material("ceramic");
        List<SteelString> guitars = new ArrayList<>();
        guitars.add(new SteelString(mats[0],brands[0]));
        guitars.get(0).setOwner("Elvis");
        guitars.add(new SteelString(mats[1],brands[1]));
        guitars.add(new SteelString(mats[2],brands[0]));
        guitars.get(2).setOwner("MLTR");
        guitars.add(new SteelString(mats[3],brands[2]));

        guitars.get(0).setMaterials(mats);
        
        for(var g : guitars){
            em.persist(g);
        }

        em.getTransaction().commit();

/*        SteelString s = new SteelString(4,"wood","Fender");
        em.persist(s);
        em.getTransaction().commit();
        SteelString t = new SteelString(5,"plastic","SM Bonus");
        em.persist(t);
        em.getTransaction().commit();
        SteelString u =  new SteelString(7,"narra","Fender");
        em.persist(u);
        em.getTransaction().commit();*/
        emf.close();
    }
}
