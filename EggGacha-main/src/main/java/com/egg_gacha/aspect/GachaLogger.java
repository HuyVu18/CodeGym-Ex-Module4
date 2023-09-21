package com.egg_gacha.aspect;

import com.egg_gacha.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GachaLogger {
    static {
        PropertyConfigurator.configure("src/main/resources/log4j_config/log4j.properties");
    }

    private static final Logger logger = LogManager.getLogger(GachaLogger.class);

    @Pointcut("execution(* com.egg_gacha.service.impl.GachaServiceImpl.updateGacha(..))")
    public void gachaMethod() {
    }

    @Around("gachaMethod()")
    public void gachaLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        User user = (User) proceedingJoinPoint.proceed();
        String args = Arrays.toString(proceedingJoinPoint.getArgs());
        logger.info(String.format("User: %s hatched an egg %s",user.getUsername(),args));
    }
}
