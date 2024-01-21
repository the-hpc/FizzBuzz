package com.hpc.FizzBuzz.service;

import com.hpc.FizzBuzz.model.FizzBuzzRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FizzBuzzServiceTest {

    @Mock
    private RequestStatsService requestStatsService;

    @InjectMocks
    private FizzBuzzService fizzBuzzService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFizzBuzzResult() {
        FizzBuzzRequest request = new FizzBuzzRequest(3, 5, 15, "Fizz", "Buzz");
        doNothing().when(requestStatsService).recordRequest(any(FizzBuzzRequest.class));

        List<String> result = fizzBuzzService.getFizzBuzzResult(request);

        assertEquals(15, result.size());
        assertEquals("Fizz", result.get(2));
        assertEquals("Buzz", result.get(4));
        assertEquals("FizzBuzz", result.get(14));

        verify(requestStatsService, times(1)).recordRequest(any(FizzBuzzRequest.class));
    }
}
