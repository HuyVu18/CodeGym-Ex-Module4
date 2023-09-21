package com.example.controller;


import com.example.model.Result;
import com.example.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
public class CurrencyController {
    @Autowired
    private ResultService resultService;

    @GetMapping({""})
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping({"/currency1"})
    public ModelAndView conversionUToV(@RequestParam("input1") double input) {
        ModelAndView modelAndView = new ModelAndView("index");
        BigDecimal bigDecimal = BigDecimal.valueOf(input * 23000);
        Result result = resultService.findOne(bigDecimal.toPlainString());
        modelAndView.addObject("result1", result);
        return modelAndView;
    }

    @RequestMapping({"/currency2"})
    public ModelAndView conversionVToU(@RequestParam("input2") double input) {
        ModelAndView modelAndView = new ModelAndView("index");
        BigDecimal bigDecimal = BigDecimal.valueOf(input / 23000);
        Result result = resultService.findOne(bigDecimal.toPlainString());
        modelAndView.addObject("result2", result);
        return modelAndView;
    }

}
