package com.hpc.FizzBuzz.service;

import com.hpc.FizzBuzz.model.FizzBuzzRequest;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RequestStatsService {

    private final ConcurrentHashMap<FizzBuzzRequest, AtomicInteger> requestCounts = new ConcurrentHashMap<>();

    public void recordRequest(FizzBuzzRequest request) {
        requestCounts.computeIfAbsent(request, k -> new AtomicInteger(0)).incrementAndGet();
    }

    public FizzBuzzRequest getMostFrequentRequest() {
        return requestCounts.entrySet().stream()
                .max((entry1, entry2) -> Integer.compare(entry1.getValue().get(), entry2.getValue().get()))
                .map(ConcurrentHashMap.Entry::getKey)
                .orElse(null);
    }

    public int getRequestCount(FizzBuzzRequest request) {
        return requestCounts.getOrDefault(request, new AtomicInteger(0)).get();
    }
}
