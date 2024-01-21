package com.hpc.FizzBuzz.controller;

import com.hpc.FizzBuzz.model.FizzBuzzRequest;
import com.hpc.FizzBuzz.service.FizzBuzzService;
import com.hpc.FizzBuzz.service.RequestStatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Autowired
    private RequestStatsService requestStatsService;
    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzController.class);

    @PostMapping("/fizzbuzz")
    public List<String> fizzBuzz(@RequestBody FizzBuzzRequest request) {
        logger.info("Received FizzBuzz request: {}", request);
        // System.out.println("INSIDE POST METHOD--------------------------------------------------------------------------");
        List<String> response = fizzBuzzService.getFizzBuzzResult(request);
        logger.info("FizzBuzz response: {}", response);
        return response;
    }

    @GetMapping("/stats/most-frequent-request")
    public ResponseEntity<?> getMostFrequentRequest() {
        logger.info("Received request for most frequent FizzBuzz request stats");
        // System.out.println("INSIDE GET METHOD--------------------------------------------------------------------------");
        FizzBuzzRequest mostFrequentRequest = requestStatsService.getMostFrequentRequest();
        if (mostFrequentRequest == null) {
            return ResponseEntity.noContent().build();
        }
        int count = requestStatsService.getRequestCount(mostFrequentRequest);
        logger.info("Most frequent FizzBuzz request: {}, Count: {}", mostFrequentRequest, count);

        return ResponseEntity.ok(Map.of(
                "request", mostFrequentRequest,
                "count", count
        ));
    }
}

