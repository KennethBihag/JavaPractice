
import static java.lang.System.*;

import com.kenneth.service.*;
import com.kenneth.model.yugioh.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args){
        out.println("Yu-gi-oh");
//without Spring
        //AcquireCards ac = new BuyDeck();
//with Spring
        ApplicationContext appCon = new AnnotationConfigApplicationContext(AppConfig.class);
        AcquireCards ac = appCon.getBean("getCards",AcquireCards.class);

        for(var card : ac.getMonsters()){
            out.printf(
                    "%s:\n\t%d:%d\n",
                    card.name(),card.level(),card.atk());
            break;
        }
//compare 2 instances of same service
        AcquireCards ac2 = appCon.getBean("getCards",AcquireCards.class);
        out.println(ac);
        out.println(ac2);
    }
}
