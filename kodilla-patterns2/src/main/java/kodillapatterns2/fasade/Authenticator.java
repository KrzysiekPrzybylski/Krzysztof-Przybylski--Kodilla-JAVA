package kodillapatterns2.fasade;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Authenticator {

    public boolean isAuthenticated(Long userId){
        Random random = new Random();
        return random.nextBoolean();
    }

}
