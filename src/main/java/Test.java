
import com.mycompany.sistemacentralizadomysql.entidades.Producto;
import com.mycompany.sistemacentralizadomysql.session.ProductoJpaController;

import java.math.BigDecimal;
import java.util.logging.Level;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;
        

public class Test {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        
        ProductoJpaController pjc = new  ProductoJpaController(emf);
        
       Producto p = new Producto();
       
       p.setNombre("MANZANA");
       Double dl = 10.35;
       BigDecimal bdl = BigDecimal.valueOf(dl.doubleValue());
       p.setPrecio(bdl);
       
        try {
            //pjc.create(p);
            //pjc.edit(p);
            pjc.destroy(1);
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        
    }
    
}
