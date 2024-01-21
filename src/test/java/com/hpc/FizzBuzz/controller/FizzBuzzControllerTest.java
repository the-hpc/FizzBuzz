package com.hpc.FizzBuzz.controller;

import com.hpc.FizzBuzz.model.FizzBuzzRequest;
import com.hpc.FizzBuzz.service.FizzBuzzService;
import com.hpc.FizzBuzz.service.RequestStatsService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FizzBuzzControllerTest {

    @InjectMocks
    private FizzBuzzController fizzBuzzController;

    @Mock
    private FizzBuzzService fizzBuzzService;

    @Mock
    private RequestStatsService requestStatsService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFizzBuzzEndpoint() {
        FizzBuzzRequest request = new FizzBuzzRequest(3, 5, 15, "Fizz", "Buzz");
        List<String> expectedResponse = Arrays.asList("1", "2", "Fizz", "4", "Buzz");
        when(fizzBuzzService.getFizzBuzzResult(request)).thenReturn(expectedResponse);

        List<String> actualResponse = fizzBuzzController.fizzBuzz(request);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetMostFrequentRequest() {
        FizzBuzzRequest mostFrequentRequest = new FizzBuzzRequest(3, 5, 15, "Fizz", "Buzz");
        when(requestStatsService.getMostFrequentRequest()).thenReturn(mostFrequentRequest);
        when(requestStatsService.getRequestCount(mostFrequentRequest)).thenReturn(10);

        ResponseEntity<?> responseEntity = fizzBuzzController.getMostFrequentRequest();
        assertEquals(200, responseEntity.getStatusCodeValue());

        Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();
        assertEquals(mostFrequentRequest, responseBody.get("request"));
        assertEquals(10, responseBody.get("count"));
    }
}

