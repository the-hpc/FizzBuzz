package com.hpc.FizzBuzz.model;

import lombok.Data;

@Data
public class FizzBuzzRequest {
    private int int1;
    private int int2;
    private int limit;
    private String str1;
    private String str2;

    public FizzBuzzRequest(int int1, int int2, int limit, String str1, String str2) {
        this.int1 = int1;
        this.int2 = int2;
        this.limit = limit;
        this.str1 = str1;
        this.str2 = str2;
    }

    public FizzBuzzRequest() {
    }
}