package com.hpc.FizzBuzz.service;

import com.hpc.FizzBuzz.model.FizzBuzzRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class RequestStatsServiceTest {

    @InjectMocks
    private RequestStatsService requestStatsService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRecordAndGetRequest() {
        FizzBuzzRequest request = new FizzBuzzRequest(3, 5, 15, "Fizz", "Buzz");
        requestStatsService.recordRequest(request);
        requestStatsService.recordRequest(request);

        assertEquals(2, requestStatsService.getRequestCount(request));
    }
}

