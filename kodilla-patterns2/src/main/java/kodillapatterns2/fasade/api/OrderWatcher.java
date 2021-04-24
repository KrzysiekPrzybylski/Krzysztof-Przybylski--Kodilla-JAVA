package kodillapatterns2.fasade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OrderWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before("execution(* kodillapatterns2.fasade.api.OrderFacade.processOrder(..))" )
//    "&& args(userId) && target(object)")
    public void logEvent(){
        LOGGER.info("Process Order is starting - jeah");
//    public void logEvent(Object object,  Long userId){
//        LOGGER.info("My Class: " + object.getClass().getName() + ", Args: " + userId);

    }
    @Around("execution(* kodillapatterns2.fasade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();                  // [1]
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();                    // [2]
            LOGGER.info("Time consumed " + (end - begin) + "[ms]");   // [3]
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());               // [4]
            throw throwable;
        }
        return result;
    }

}
