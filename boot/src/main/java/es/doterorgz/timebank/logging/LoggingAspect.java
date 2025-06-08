package es.doterorgz.timebank.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(loggable)")
    public Object logMethod(ProceedingJoinPoint pjp, Loggable loggable) throws Throwable {
        Class<?> targetClass = pjp.getTarget().getClass();
        Logger logger = LoggerFactory.getLogger(targetClass);
        String className = targetClass.getSimpleName();
        String methodName = pjp.getSignature().getName();

        if (loggable.logParameters()) {
            logger.info("[{}]({}) START params={}", className, methodName, Arrays.toString(pjp.getArgs()));
        } else {
            logger.info("[{}]({}) START", className, methodName);
        }

        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = pjp.proceed();
            return result;
        } finally {
            long end = System.currentTimeMillis();
            StringBuilder message = new StringBuilder();
            message.append("[").append(className).append("](").append(methodName).append(") STOP");
            if (loggable.logResult()) {
                message.append(" result=").append(result);
            }
            if (loggable.logExecutionTime()) {
                message.append(" time=").append(end - start).append("ms");
            }
            logger.info(message.toString());
        }
    }
}
