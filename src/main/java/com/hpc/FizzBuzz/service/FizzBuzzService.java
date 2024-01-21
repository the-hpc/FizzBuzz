package com.hpc.FizzBuzz.service;

import com.hpc.FizzBuzz.model.FizzBuzzRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzService {
    @Autowired
    private RequestStatsService requestStatsService;
    public List<String> getFizzBuzzResult(FizzBuzzRequest request) {
        requestStatsService.recordRequest(request);

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= request.getLimit(); i++) {
            if (i % request.getInt1() == 0 && i % request.getInt2() == 0) {
                result.add(request.getStr1() + request.getStr2());
            } else if (i % request.getInt1() == 0) {
                result.add(request.getStr1());
            } else if (i % request.getInt2() == 0) {
                result.add(request.getStr2());
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}