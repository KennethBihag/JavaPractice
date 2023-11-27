import com.kenneth.repository.CardGroup;
import com.kenneth.repository.Deck;
import com.kenneth.service.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan({"com.kenneth"})
public class AppConfig {
/*

    //@Scope(BeanDefinition.SCOPE_SINGLETON)
    //@Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean(name = "getCards")
    public AcquireCards getCardsService(){
        BuyDeck buyDeck = new BuyDeck();
        //buyDeck.setCards(getDeck());
        return buyDeck;
    }
    @Bean(name = "deck")
    public CardGroup getDeck(){
        System.out.println("Bean: deck started...");
        return new Deck();
    }
*/

    @Bean(name = "mrBean")
    public int mrBean(){
        System.out.println("Mr. Bean is coming to town.");
        return 0;
    }
}
