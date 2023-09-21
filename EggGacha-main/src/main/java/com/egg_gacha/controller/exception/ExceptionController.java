package com.egg_gacha.controller.exception;

import com.egg_gacha.aspect.GachaLogger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
    private static final Logger logger = LogManager.getLogger(GachaLogger.class);
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e){
        System.out.println("Error: " +  e.getMessage());
        e.printStackTrace();
        logger.error(e);
        return new ModelAndView("main-error");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ModelAndView handleException(ConstraintViolationException e){
        logger.error("ConstraintViolation: " +  e.getMessage());
        return new ModelAndView("main-error");
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView handleException(DataIntegrityViolationException e){
        logger.error("DataIntegrityViolation: " +  e.getMessage());
        return new ModelAndView("main-error");
    }
}
