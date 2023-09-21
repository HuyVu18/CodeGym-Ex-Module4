package com.example.service.impl;

import com.example.model.Result;
import com.example.service.ResultService;

public class ResultServiceImpl implements ResultService {
    @Override
    public Result findOne(String inputCurrency) {
        return new Result(inputCurrency);
    }
}
